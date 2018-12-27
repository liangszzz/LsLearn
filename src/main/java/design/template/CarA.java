package design.template;

public class CarA extends Car{
    @Override
    public String getName() {
        return "宝马";
    }

    @Override
    public String getSpecifications() {
        return "四驱";
    }

    @Override
    public boolean isAlarm() {
        return false;
    }

    @Override
    public String getAlarm() {
        return null;
    }
}
