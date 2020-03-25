package design.signle;

public final class Single4 {


    private static class SingleHolder {

        public final static Single4 INSTANCE = new Single4();

    }

    /**
     * 利用classLoader加载为单线程,实现线程安全
     */
    public static Single4 getInstance() {
        return SingleHolder.INSTANCE;
    }

}
