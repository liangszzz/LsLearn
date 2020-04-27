package threads.condition;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Queue {

    private Lock lock = new ReentrantLock();

    private Condition emptyCondition = lock.newCondition();

    private Condition fullCondition = lock.newCondition();

    private String[] list;

    private int max;

    private int size = 0;

    public Queue(int max) {
        this.max = max;
        this.list = new String[max];
    }

    public static void main(String[] args) throws IOException {


        Queue queue = new Queue(10);

        new Thread(new QueueGetRunnable(queue)).start();
        new Thread(new QueueGetRunnable(queue)).start();
        new Thread(new QueuePutRunnable(queue)).start();
//        new Thread(new QueuePutRunnable(queue)).start();

        System.in.read();
    }

    static class QueuePutRunnable implements Runnable {

        private Queue queue;

        private Random random = new Random();

        QueuePutRunnable(Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                int i = random.nextInt(10);
                queue.put(i + "");
                System.out.println(Thread.currentThread().getId() + ":put:" + i);
                try {
                    Thread.sleep(i * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class QueueGetRunnable implements Runnable {

        private Queue queue;

        QueueGetRunnable(Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                String s = queue.get();
                System.out.println(Thread.currentThread().getId() + ":GET:" + s);
                try {
                    Thread.sleep((int) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void put(String str) {
        lock.lock();
        try {
            while (size == max - 1) {
                System.out.println("queue full");
                fullCondition.await();
            }
            list[size] = str;
            size++;
            emptyCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public String get() {
        lock.lock();
        try {
            while (size == 0) {
                System.out.println("queue empty");
                emptyCondition.await();
            }
            String str = list[size - 1];
            size--;
            fullCondition.signal();
            return str;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }
}
