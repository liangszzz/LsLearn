package threads;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 生产消费者模型
 */
public class KFC {

    private static Queue<String> queue1 = new ConcurrentLinkedQueue<>();

    private static Queue<String> queue2 = new ConcurrentLinkedQueue<>();


    public static void main(String[] args) {

        Cashier cashier = new Cashier();
        Thread thread0 = new Thread(cashier);
        thread0.start();

        Provider provider = new Provider();
        Thread thread00 = new Thread(provider);
        thread00.start();

        Customer customer1 = new Customer("张三");
        Customer customer2 = new Customer("李四");

        Thread thread1 = new Thread(customer1);
        Thread thread2 = new Thread(customer2);
        thread1.start();
        thread2.start();
    }

    /**
     * 消费者/顾客
     */
    static class Customer implements Runnable {

        Random random = new Random();

        private String name;

        Customer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            int i = 0;
            while (i++ < 10) {
                int id = random.nextInt(20);
                queue1.add(id + "__food");
                System.out.println(name + "##点菜" + id + "__food");
                try {
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 收营员
     */
    static class Cashier implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (queue1.peek() != null) {
                    String food = queue1.poll();
                    System.out.println("##通知厨房##" + food);
                    queue2.add(food);
                }
            }
        }
    }

    /**
     * 提供者 chef/厨师
     */
    static class Provider implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (queue2.peek() != null)
                    System.out.println("#do##" + queue2.poll());
            }
        }
    }

}
