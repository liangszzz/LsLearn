package threads.lock;


import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * 自旋
 * CAS
 * LockSupport.park/unpark
 */
public class MyLock implements Lock {

    private static Unsafe unsafe;

    private volatile int state;

    private static long offset;

    private ConcurrentLinkedQueue<Thread> set = new ConcurrentLinkedQueue<>();

    private Thread current;

    static {

        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            offset = unsafe.objectFieldOffset(MyLock.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void lock() {
//        System.out.println("lock    " + Thread.currentThread().getName());
        while (!tryLock()) {
            set.add(Thread.currentThread());
            LockSupport.park();
//            System.out.println("lock  park  " + Thread.currentThread().getName() + "");
        }
        current = Thread.currentThread();
//        System.out.println("lock  success  " + Thread.currentThread().getName() + "");
    }

    public void lockInterruptibly() throws InterruptedException {

    }

    public boolean tryLock() {
//        System.out.println("tryLock     " + Thread.currentThread().getName());
        return unsafe.compareAndSwapInt(this, offset, 0, 1);
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public void unlock() {
        if (current.equals(Thread.currentThread())) {
            setState(0);
            if (!set.isEmpty()) {
                LockSupport.unpark(set.poll());
            }
        }
//        System.out.println("unlock     " + Thread.currentThread().getName());
    }

    public Condition newCondition() {
        return null;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
