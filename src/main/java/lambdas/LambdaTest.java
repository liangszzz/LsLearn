package lambdas;

public class LambdaTest {

    @FunctionalInterface
    interface InterDA {

        void doSome();
    }

    void doSome(InterDA interDA) {
        System.out.println("lambda fa ");
        interDA.doSome();
    }

    public static void main(String[] args) {
        LambdaTest test = new LambdaTest();
        test.doSome(() -> {
            System.out.println("aaaaa");
        });
    }
}

