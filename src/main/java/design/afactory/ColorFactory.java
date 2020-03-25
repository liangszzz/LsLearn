package design.afactory;

import design.factory.Shape;

import java.lang.reflect.InvocationTargetException;

public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(Class<? extends Color> clazz) {
        Color color = null;
        try {
            color = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return color;
    }

    @Override
    public Shape getShape(Class<? extends Shape> clazz) {
        return null;
    }
}
