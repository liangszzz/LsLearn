package design.prototype;

import lombok.Data;

@Data
public class Book implements Cloneable {

    private String a;

    private int b;

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return new Book();
        }
    }

    public void test0() {
        Book book1 = new Book();
        book1.setA("111");
        book1.setB(19);

        Book book = (Book) book1.clone();
        System.out.println(book);
    }
}
