package design.template;


public class TestTemplate {

    public void test0() {

        Car cara = new CarA();
        Car carb = new CarB();

        cara.run();
        carb.run();
    }

    public void test1() {

        Car cara = new CarA();
        Car carb = new CarB();
        ((CarB) carb).setAlarm(true);
        cara.run();
        carb.run();
    }
}
