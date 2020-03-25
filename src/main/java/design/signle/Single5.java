package design.signle;

public enum Single5 {


    INSTANCE;

    private final Object obj = new Object();

    public Object doSome() {
        return obj;
    }

}
