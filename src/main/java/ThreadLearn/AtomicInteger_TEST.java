package ThreadLearn;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicInteger_TEST {

    @Test
    public void Test0() {

        AtomicInteger integer = new AtomicInteger(0);
        int i = integer.addAndGet(10);
        System.out.println(i);

        AtomicInteger integer2 = new AtomicInteger(0);
        int j = integer2.getAndAdd(10);
        System.out.println(j);
    }
}
