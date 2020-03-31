package threads.product;

import lombok.SneakyThrows;

public class Application {

    public static void main(String[] args) {
        Pool pool = new Pool(100);
        new ProductThread(pool).start();
        new ConsumerThread(pool).start();
    }

    static class ProductThread extends Thread {

        private Pool pool;

        ProductThread(Pool pool) {
            this.pool = pool;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (true)
                pool.product();
        }
    }

    static class ConsumerThread extends Thread {
        private Pool pool;

        ConsumerThread(Pool pool) {
            this.pool = pool;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                String consumer = pool.consumer();
                System.out.println("消费  " + consumer);
            }
        }
    }
}
