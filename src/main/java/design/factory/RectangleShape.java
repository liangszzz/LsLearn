package design.factory;

public class RectangleShape implements Shape {

    @Override
    public void draw() {
        System.out.println("##RectangleShape");
    }
}
