package design.afactory;

import design.factory.Shape;

import java.lang.reflect.InvocationTargetException;

public class ShapeFactory extends AbstractFactory {


    @Override
    public Color getColor(Class<? extends Color> clazz) {
        return null;
    }

    @Override
    public Shape getShape(Class<? extends Shape> clazz) {
        Shape shape = null;
        try {
            shape = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return shape;
    }
}
