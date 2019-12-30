package ThreadLearn;

import org.openjdk.jol.info.ClassLayout;

public class Sync {

    public static void main(String[] args) {

        Car car = new Car();
        System.out.println(car.hashCode());

        System.out.println(ClassLayout.parseInstance(car).toPrintable());

        synchronized (car) {

            System.out.println("#########");

            System.out.println(ClassLayout.parseInstance(car).toPrintable());

        }

    }
}
