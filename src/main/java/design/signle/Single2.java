package design.signle;

public final class Single2 {

    public static Single2 s = null;

    private Single2() {

    }

    public static synchronized Single2 getInstance() {
        if (s == null) {
            s = new Single2();
        }
        return s;
    }

}
