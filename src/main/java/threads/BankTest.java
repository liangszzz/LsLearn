package threads;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行取钱问题
 */
public class BankTest {


    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        PeopleA peopleA1 = new PeopleA("peopleA1", 100, bank);
        PeopleA peopleA2 = new PeopleA("peopleA2", 200, bank);

        PeopleB peopleB1 = new PeopleB("peopleB1", 100, bank);
        PeopleB peopleB2 = new PeopleB("peopleB2", 200, bank);

        Thread thread1 = new Thread(peopleA1);
        Thread thread2 = new Thread(peopleA2);
        Thread thread3 = new Thread(peopleB1);
        Thread thread4 = new Thread(peopleB2);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    static class Bank {
        private int all = 10000;

        private ReentrantLock lock = new ReentrantLock();

        public void getMoneyFromATM(String people, int money) {
            StringBuffer buffer = new StringBuffer();
            lock.lock();
            buffer.append(people).append("\t总金额\t").append(all).append("\tATM取\t").append(money);
            try {
                if (all >= money) {
                    all -= money;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            buffer.append("\t余额\t").append(all);
            System.out.println(buffer.toString());
        }

        public void getMoneyFromBank(String people, int money) {
            StringBuffer buffer = new StringBuffer();
            lock.lock();
            buffer.append(people).append("\t总金额\t").append(all).append("\tBANK取\t").append(money);
            try {
                if (all >= money) {
                    all -= money;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            buffer.append("\t余额\t").append(all);
            System.out.println(buffer.toString());
        }
    }


    static class PeopleA implements Runnable {

        private String name;

        private int money;

        private Bank bank;

        Random random = new Random();

        public PeopleA(String name, int money, Bank bank) {
            this.name = name;
            this.money = money;
            this.bank = bank;
        }

        @Override
        public void run() {
            while (true) {
                bank.getMoneyFromATM(name, money);
                try {
                    Thread.sleep(random.nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class PeopleB implements Runnable {

        private String name;

        private int money;

        private Bank bank;

        Random random = new Random();

        public PeopleB(String name, int money, Bank bank) {
            this.name = name;
            this.money = money;
            this.bank = bank;
        }

        @Override
        public void run() {
            while (true) {
                bank.getMoneyFromBank(name, money);
                try {
                    Thread.sleep(random.nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
