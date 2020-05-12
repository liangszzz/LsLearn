package pool2;

import lombok.Getter;

import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.concurrent.locks.ReentrantLock;

public class BufferPage {

    private int pageIndex;

    private final BitSet bitSet;

    @Getter
    private final ByteBuffer buffer;

    private final int max;

    @Getter
    private volatile boolean allocate = false;

    private final ReentrantLock lock = new ReentrantLock();


    public BufferPage(int pageIndex, int size) {
        this.pageIndex = pageIndex;
        this.max = size;
        this.bitSet = new BitSet(size);
        this.bitSet.set(0, size, false);
        this.buffer = ByteBuffer.allocateDirect(size);
    }

    public VirtualBuffer allocate(int size) {
        lock.lock();
        allocate = true;
        try {
            int start = bitSet.nextClearBit(0);
            if (start == -1) return null;

            while (start < max) {
                int end = bitSet.nextSetBit(start);
                if (end == -1) {
                    end = max;
                }
                if (end > buffer.capacity())
                    return null;
                if (end - start >= size) {
                    bitSet.set(start, start + size);
                    buffer.limit(start + size);
                    buffer.position(start);
                    ByteBuffer slice = buffer.slice();
                    return new VirtualBuffer(this, start, start + size, slice, true);
                }
                start = bitSet.nextClearBit(end);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        } finally {
            allocate = false;
            lock.unlock();
        }
    }

    public void release(VirtualBuffer buffer) {
        lock.lock();
        try {
            bitSet.clear(buffer.getStart(), buffer.getEnd());
        } finally {
            lock.unlock();
        }
    }
}
