package ThreadLearn;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 多个站台卖多张票
 */
public class Ticket {

    private static final int sleep_time = 256;

    private static final int ticket_count = 30;

    public void all(Runnable station) throws InterruptedException {
        Thread thread = new Thread(station);
        Thread thread1 = new Thread(station);
        Thread thread2 = new Thread(station);
        thread.start();
        thread1.start();
        thread2.start();
        thread.join();
    }

    @Test
    public void test4() throws InterruptedException {
        Station4 station = new Station4();
        all(station);
    }

    @Test
    public void test3() throws InterruptedException {
        Station3 station = new Station3();
        all(station);
    }

    @Test
    public void test2() throws InterruptedException {
        Station2 station = new Station2();
        all(station);
    }


    @Test
    public void test0() throws InterruptedException {
        Station1 station = new Station1();
        all(station);
    }


    static class Station1 implements Runnable {

        private int count = ticket_count;

        @Override
        public synchronized void run() {
            while (count > 0) {
                System.out.println("第{" + count + "}张票");
                count--;
            }
            try {
                Thread.sleep(sleep_time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Station2 implements Runnable {

        private AtomicInteger count = new AtomicInteger(ticket_count);

        @Override
        public void run() {
            while (count.get() > 0) {
                System.out.println("第{" + count.getAndDecrement() + "}张票");
            }
            try {
                Thread.sleep(sleep_time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Station3 implements Runnable {

        private volatile int count = ticket_count;

        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        @Override
        public void run() {

            while (count > 0) {
                System.out.println("第{" + count + "}张票");
                try {
                    lock.writeLock().lock();
                    count--;
                } finally {
                    lock.writeLock().unlock();
                }
            }

            try {
                Thread.sleep(sleep_time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Station4 implements Runnable {

        private volatile int count = ticket_count;

        @Override
        public void run() {
            while (count > 0) {
                System.out.println("第{" + count + "}张票");
                synchronized (this) {
                    count--;
                }
            }
            try {
                Thread.sleep(sleep_time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
