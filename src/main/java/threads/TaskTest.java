package threads;

import java.util.concurrent.*;

/**
 * @author admin
 * <p>
 * newFixedThreadPool 定长线程池
 * newCachedThreadPool 可缓存线程池
 * newSingleThreadExecutor 单线程线程池
 * newScheduledThreadPool 固定长度的定时任务线程池
 */
public class TaskTest {

    public static void main(String[] args) throws Exception {
        Task1();
        Task2();
        Task3();
    }

    public static void Task1() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Callable<Integer> callable = () -> {
            System.out.println("####");
            Thread.sleep(400);
            return 10;
        };

        Future<Integer> submit = executor.submit(callable);

        System.out.println(submit.get());
        executor.shutdown();
    }

    public static void Task2() throws Exception {

        Callable<Integer> callable = () -> {
            Thread.sleep(400);
            System.out.println("##2");
            return 100;
        };

        FutureTask<Integer> future = new FutureTask<>(callable);

        /**
         * 直接手动执行
         */
        future.run();
        System.out.println(future.get());

        /**
         * 启动新线程 循环等待
         */
        new Thread(future).start();
        System.out.println(future.get());


    }

    /**
     *
     */
    public static void Task3() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        CompletionService<Integer> completionService = new ExecutorCompletionService(executor);

        completionService.submit(() -> {
            Thread.sleep(400);
            System.out.println("##");
            return 110;
        });

        Future<Integer> take = completionService.take();
        if (take.isDone())
            System.out.println(take.get());

        executor.shutdown();

    }


}
