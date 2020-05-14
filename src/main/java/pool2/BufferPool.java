package pool2;

import lombok.ToString;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@ToString
public class BufferPool {

    private final int poolSize;

    private int pageSize;

    private int cursor;

    private final BufferPage[] pages;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public BufferPool(int poolSize, int pageSize) {
        this.pageSize = pageSize;
        int len = (int) Math.ceil((double) poolSize / pageSize);
        this.pages = new BufferPage[len];
        this.poolSize = len * pageSize;
        for (int i = 0; i < this.pages.length; i++) {
            this.pages[i] = new BufferPage(i, pageSize);
        }
    }

    private int getPageSize() {
        lock.readLock().lock();
        try {
            return pageSize;
        } finally {
            lock.readLock().unlock();
        }
    }

    private void setPageSize(int pageSize) {
        lock.writeLock().lock();
        try {
            this.pageSize = pageSize;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public VirtualBuffer allocate(int size) {
        assert size > 0;
        if (size > getPageSize()) {
            return new VirtualBuffer(null, 0, size, ByteBuffer.allocate(size), false);
        }
        cursor = (cursor + 1) % this.pages.length;
        BufferPage page = this.pages[cursor];
        if (page.isAllocate()) return allocate(size);
        VirtualBuffer allocate = page.allocate(size);
        if (allocate != null) return allocate;
        return new VirtualBuffer(null, 0, size, ByteBuffer.allocate(size), false);
    }

    public void shutdown() {
        setPageSize(0);
        for (BufferPage page : pages) {
            ByteBuffer buffer = page.getBuffer();
            if (buffer.isDirect()) {

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferPool pool = new BufferPool(2048, 512);

        Read read2 = new Read(pool, 120);

        new Thread(read2).start();
        new Thread(read2).start();
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
                VirtualBuffer virtualBuffer = null;
                try (FileInputStream stream = new FileInputStream("C:\\Users\\EDZ\\Desktop\\fsdownload\\springboot.out")) {
                    FileChannel channel = stream.getChannel();
                    virtualBuffer = pool.allocate(size);
                    ByteBuffer buffer = virtualBuffer.getBuffer();
                    while (true) {
                        if (channel.read(buffer) == -1) break;
                        buffer.flip();
                        StringBuilder builder = new StringBuilder();
                        while (buffer.hasRemaining()) {
                            builder.append((char) buffer.get());
                        }
                        buffer.clear();
                        System.out.println(Thread.currentThread().getId() + ":" + virtualBuffer);
                    }
                } catch (Exception e) {
                    System.out.println(Thread.currentThread().getId());
                    e.printStackTrace();
                    System.exit(0);
                } finally {
                    Random random = new Random();
                    int i = random.nextInt(10);
                    try {
                        Thread.sleep(10 * i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                    if (virtualBuffer != null)
                        virtualBuffer.release();
                }

            }
        }
    }
}
