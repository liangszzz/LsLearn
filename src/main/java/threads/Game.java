package threads;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * 对战游戏学习CyclicBarrier
 */
public class Game {

    public static void main(String[] args) throws IOException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("#等待时间#");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread1 = new Thread(new Player("张三", cyclicBarrier));
        Thread thread2 = new Thread(new Player("李四", cyclicBarrier));
        Thread thread3 = new Thread(new Player("王五", cyclicBarrier));

        thread1.start();
        thread2.start();
        thread3.start();

        System.in.read();
    }


    static class Player implements Runnable {

        Random random = new Random();

        private String name;

        private CyclicBarrier cyclicBarrier;

        public Player(String name, CyclicBarrier cyclicBarrier) {
            this.name = name;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(random.nextInt(140));
                System.out.println(name + "#开始匹配玩家" + LocalDateTime.now());
                cyclicBarrier.await();
                System.out.println("#匹配玩家结束#");

                Thread.sleep(random.nextInt(200));
                System.out.println(name + "#开始选择英雄" + LocalDateTime.now());
                cyclicBarrier.await();
                System.out.println("#选择英雄结束#");

                Thread.sleep(random.nextInt(1500));
                System.out.println(name + "#开始加载游戏" + LocalDateTime.now());
                cyclicBarrier.await();
                System.out.println("#加载游戏结束#");
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }


}
