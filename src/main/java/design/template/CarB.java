package design.template;

public class CarB extends Car {

    boolean isAlarm = true;

    @Override
    public String getName() {
        return "奔驰";
    }

    @Override
    public String getSpecifications() {
        return "后驱";
    }

    @Override
    public boolean isAlarm() {
        return isAlarm;
    }

    @Override
    public String getAlarm() {
        return "hhh";
    }

    public void setAlarm(boolean alarm) {
        isAlarm = alarm;
    }
}
