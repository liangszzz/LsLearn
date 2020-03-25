package design.signle;

public final class Single1 {

    public final static Single1 s = new Single1();

    private Single1() {

    }

    public static Single1 getInstance() {
        return s;
    }

}
