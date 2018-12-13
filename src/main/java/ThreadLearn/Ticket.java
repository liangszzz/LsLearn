package ThreadLearn;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 多个站台卖多张票
 */
public class Ticket {

    @Test
    public void test0() throws InterruptedException {
        Station1 station = new Station1();
        Thread thread = new Thread(station);
        Thread thread1 = new Thread(station);
        Thread thread2 = new Thread(station);
        thread.start();
        thread1.start();
        thread2.start();
        thread.join();
    }

    @Test
    public void test2() throws InterruptedException {
        Station2 station = new Station2();
        Thread thread = new Thread(station);
        Thread thread1 = new Thread(station);
        Thread thread2 = new Thread(station);
        thread.start();
        thread1.start();
        thread2.start();
        thread.join();
    }

    @Test
    public void test3() throws InterruptedException {
        Station3 station = new Station3();
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
        Thread thread = new Thread(station);
        Thread thread1 = new Thread(station);
        Thread thread2 = new Thread(station);
        thread.start();
        thread1.start();
        thread2.start();
        thread.join();
    }

    static class Station1 implements Runnable {

        private int count = 30;

        private Object lock = "lock";
        Random random = new Random();

        @Override
        public void run() {
            while (count > 0) {
                synchronized (lock) {
                    if (count > 0) {
                        System.out.println("第{" + count + "}张票");
                        count--;
                    } else {
                        System.out.println("票已买完");
                        break;
                    }
                }
                try {
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Station2 implements Runnable {

        private AtomicInteger count = new AtomicInteger(30);

        Random random = new Random();

        @Override
        public void run() {
            while (true) {
                if (count.get() > 0) {
                    System.out.println("第{" + count.get() + "}张票");
                    count.getAndAdd(-1);
                } else {
                    System.out.println("票已买完");
                    break;
                }
                try {
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Station3 implements Runnable {

        private int count = 30;

        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Random random = new Random();

        @Override
        public void run() {
            while (true) {
                try {
                    lock.readLock().lock();
                    if (count > 0) {
                        System.out.println("第{" + count + "}张票");
                        try {
                            lock.readLock().unlock();
                            lock.writeLock().lock();
                            count--;

                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            lock.writeLock().unlock();
                            lock.readLock().lock();
                        }
                    } else {
                        System.out.println("票已买完");
                        break;
                    }
                } catch (Exception e) {

                } finally {
                    lock.readLock().unlock();
                }

                try {
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    static class Station4 implements Runnable {

        private volatile int count = 30;

        Random random = new Random();

        @Override
        public void run() {
            while (count > 0) {
                if (count > 0) {
                    System.out.println("第{" + count + "}张票");
                    count--;
                } else {
                    System.out.println("票已买完");
                    break;
                }
            }
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
