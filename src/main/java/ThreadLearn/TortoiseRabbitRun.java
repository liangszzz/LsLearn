package ThreadLearn;

import java.time.LocalDateTime;

/**
 * 龟兔赛跑
 */
public class TortoiseRabbitRun {

    static final int all = 15;

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.of(2018, 12, 14, 14, 52, 0);

        Tortoise tortoise = new Tortoise(localDateTime);
        Rebbit rebbit = new Rebbit(localDateTime);

        Thread tortoiseThread = new Thread(tortoise);
        Thread rebbitThread = new Thread(rebbit);

        tortoise.setRebbitThread(rebbitThread);
        rebbit.setTortoiseThread(tortoiseThread);
        tortoiseThread.start();
        rebbitThread.start();

    }


    public static class Tortoise implements Runnable {

        private LocalDateTime startTime;

        private Thread rebbitThread;

        public Tortoise(LocalDateTime localDateTime) {
            this.startTime = localDateTime;
        }


        @Override
        public void run() {
            int last = all;
            int dis = 1;

            while (true) {
                if (LocalDateTime.now().isAfter(startTime)) {
                    last = last - dis;
                    if (last <= 0) {
                        System.out.println("#乌龟结束#" + LocalDateTime.now());
                        if (rebbitThread != null) {
//                            while (rebbitThread.isAlive()) {
//                                rebbitThread.interrupt();
//                            }
                        }
                        break;
                    }
                    System.out.println("当前时间" + LocalDateTime.now() + "#乌龟剩余" + last);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }

        public void setRebbitThread(Thread rebbitThread) {
            this.rebbitThread = rebbitThread;
        }
    }

    public static class Rebbit implements Runnable {

        private LocalDateTime startTime;

        private Thread tortoiseThread;

        public Rebbit(LocalDateTime localDateTime) {
            this.startTime = localDateTime;
        }

        private int count = 0;

        @Override
        public void run() {
            int last = all;
            int dis = 5;

            while (true) {
                if (LocalDateTime.now().isAfter(startTime)) {
                    last = last - dis;
                    count++;
                    if (last <= 0) {
                        System.out.println("#兔子结束#" + LocalDateTime.now());
                        try {
                            if (tortoiseThread != null) {
//                            while (tortoiseThread.isAlive()) {
//                                tortoiseThread.interrupt();
//                            }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            break;
                        }

                    }
                    System.out.println("当前时间" + LocalDateTime.now() + "#兔子剩余" + last);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (count % 2 == 0) {
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }

        public void setTortoiseThread(Thread tortoiseThread) {
            this.tortoiseThread = tortoiseThread;
        }
    }
}
