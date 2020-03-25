package design.afactory;

import design.factory.Shape;

public abstract class AbstractFactory {

    public abstract Color getColor(Class<? extends Color> clazz);

    public abstract Shape getShape(Class<? extends Shape> clazz);


    public static void main(String[] args) {
        FactoryCreator factoryCreator=new FactoryCreator();
        AbstractFactory colorFactory = factoryCreator.getFactory("color");

        Color color = colorFactory.getColor(RedColor.class);
        color.fill();

    }

}
