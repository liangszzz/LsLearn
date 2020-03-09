package ThreadLearn.lock;

import java.util.concurrent.locks.ReentrantLock;

public class Application {

    public static void main(String[] args) throws InterruptedException {

        MyLock lock = new MyLock();

        final Stock s = new Stock(1000);

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    while (s.getSize() > 0) {
                        lock.lock();
                        if (s.getSize() > 0)
                            s.decrease();
                        lock.unlock();
                    }
                }
            });
            thread.start();
        }

        Thread.currentThread().join(2000);

        System.out.println(s.getSize());
    }
}
