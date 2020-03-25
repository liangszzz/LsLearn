package design.signle;

public class M {

    public static void main(String[] args) {


        Object o = Single5.INSTANCE.doSome();
        Object o1 = Single5.INSTANCE.doSome();

        System.out.println(o.equals(o1));

    }

}
