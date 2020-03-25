package design.factory;

import java.lang.reflect.InvocationTargetException;

public class ShapeFactory {


    public Shape getBean(Class<? extends Shape> clazz) {
        if (clazz == null) {
            return null;
        }
        Shape shape = null;
        try {
            shape = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return shape;
    }


    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape bean = factory.getBean(CircleShape.class);

        bean.draw();
    }

}
