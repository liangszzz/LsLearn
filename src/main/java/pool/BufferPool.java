package pool;


import com.sun.corba.se.pept.transport.ByteBufferPool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.BitSet;
import java.util.concurrent.locks.ReentrantLock;

public class BufferPool {

    private final ByteBuffer buffer;

    private final BitSet bitSet;

    private final int max;

    public volatile static BufferPool INSTANCE;

    public static BufferPool getInstance(int size, boolean isDirect) {
        if (INSTANCE == null) {
            synchronized (BufferPool.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BufferPool(size, isDirect);
                    return INSTANCE;
                }
            }
        }
        return INSTANCE;
    }

    private ReentrantLock lock = new ReentrantLock();

    private BufferPool(int size, boolean isDirect) {
        this.max = size;
        this.buffer = allocate0(size, isDirect);
        this.bitSet = new BitSet(size);
        this.bitSet.set(0, size, false);
    }

    /**
     * 申请内存
     *
     * @param size     大小
     * @param isDirect 是否为堆外内存
     * @return ByteBuffer
     */
    private ByteBuffer allocate0(int size, boolean isDirect) {
        return isDirect ? ByteBuffer.allocateDirect(size) : ByteBuffer.allocate(size);
    }

    public VirtualBuffer allocate(int size) {
        lock.lock();
        try {
            int start = bitSet.nextClearBit(0);
            if (start == -1) throw new RuntimeException("out of memory");

            while (start < max) {
                int end = bitSet.nextSetBit(start);
                if (end == -1) {
                    end = max;
                }
                if (end > buffer.capacity())
                    throw new RuntimeException("out of memory");
                if (end - start >= size) {
                    bitSet.set(start, start + size);
                    buffer.limit(end);
                    buffer.position(start);
                    ByteBuffer slice = buffer.slice();
                    return new VirtualBuffer(start, start + size, slice);
                }
                start = bitSet.nextClearBit(end);
            }
            throw new RuntimeException("out of memory");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        } finally {
            lock.unlock();
        }
    }

    public void release(VirtualBuffer buffer) {
        bitSet.clear(buffer.getStart(), buffer.getEnd());
    }


    public static void main(String[] args) throws IOException {
        BufferPool pool = BufferPool.getInstance(2048, true);

        Read read = new Read(pool, 64);
        Read read1 = new Read(pool, 128);
        Read read2 = new Read(pool, 32);

        new Thread(read).start();
        new Thread(read1).start();
        new Thread(read2).start();
        new Thread(read2).start();
        new Thread(read2).start();
        new Thread(read2).start();
    }

    static class Read implements Runnable {

        private final BufferPool pool;

        private final int size;

        Read(BufferPool pool, int size) {
            this.pool = pool;
            this.size = size;
        }

        @Override
        public void run() {
            while (true) {
                FileChannel channel = null;
                try {
                    channel = new FileInputStream("C:\\Users\\EDZ\\Desktop\\fsdownload\\springboot.out").getChannel();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                VirtualBuffer virtualBuffer = null;
                try {
                    virtualBuffer = pool.allocate(size);
                } catch (Exception e) {
                    System.out.println(Thread.currentThread().getId());
                    e.printStackTrace();
                    System.exit(0);
                }
                ByteBuffer buffer = virtualBuffer.getBuffer();
                while (true) {
                    try {
                        if (!(channel.read(buffer) != -1)) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.exit(0);
                    }
                    buffer.flip();
                    StringBuilder builder = new StringBuilder();
                    while (buffer.hasRemaining()) {
                        builder.append((char) buffer.get());
                    }
                    buffer.clear();
                    System.out.println(Thread.currentThread().getId() + ":" + builder);
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.exit(0);
                }
                pool.release(virtualBuffer);
            }
        }
    }
}
