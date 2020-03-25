package design.signle;

public final class Single3 {

    public static Single3 s = null;

    private Single3() {

    }

    public static Single3 getInstance() {
        if (s == null) {
            synchronized (Single3.class) {
                if (s == null) {
                    s = new Single3();
                }
            }
        }
        return s;
    }

}
