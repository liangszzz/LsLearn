package design.afactory;

public class FactoryCreator {

    private ColorFactory colorFactory = new ColorFactory();
    private ShapeFactory shapeFactory = new ShapeFactory();


    public AbstractFactory getFactory(String name) {
        if ("color".equals(name)) {
            return colorFactory;
        } else if ("shape".equals(name)) {
            return shapeFactory;
        }
        return null;
    }

}
