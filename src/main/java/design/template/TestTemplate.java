package design.template;

import org.junit.Test;

public class TestTemplate {

    @Test
    public void test0() {

        Car cara = new CarA();
        Car carb = new CarB();

        cara.run();
        carb.run();
    }

    @Test
    public void test1() {

        Car cara = new CarA();
        Car carb = new CarB();
        ((CarB) carb).setAlarm(true);
        cara.run();
        carb.run();
    }
}
