package design.template;

public abstract class Car {


    public abstract String getName();


    public abstract String getSpecifications();

    public abstract boolean isAlarm();

    public abstract String getAlarm();

    public final void run() {
        System.out.println(getName() + ":" + getSpecifications());
        if (isAlarm()) {
            System.out.println(getAlarm());
        }
    }

}
