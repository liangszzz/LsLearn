package jvm.obj;

public class Obj {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000000; i++) {
            User user = new User();
        }
    }

    static class User {


        private Object[] obj = new Object[1024];

    }
}
