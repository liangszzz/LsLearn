import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.*;

public class BigDecimalTest {

    @Test
    public void test0() {

        BigDecimal bigDecimal = new BigDecimal(1289.99d);
        BigDecimal val = BigDecimal.valueOf(1289.99d);

        System.out.println(bigDecimal.doubleValue());
    }

    @Test
    public void t2() {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            list.add(i);
        }

        list.remove(1);
    }

    @Test
    public void t3() {

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 10; i++) {

            list.add(i);
        }
        list.remove(0);

    }

    @Test
    public void t4() {

        TimeUnit unit;
        BlockingQueue workQueue;
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 5, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10));
        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        poolExecutor.shutdown();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService2 = Executors.newCachedThreadPool();
    }


    @Test
    public void t5() {
        System.out.println((1 << 2) - 1);
        System.out.println(-1 << 2);

        String s = Integer.toBinaryString(3);
        System.out.println(s);
        String s1 = Integer.toBinaryString(-4);
        System.out.println(s1);

        TreeMap map = new TreeMap<>();
        map.put("A", 1);

    }

}
