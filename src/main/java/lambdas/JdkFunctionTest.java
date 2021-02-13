package lambdas;

import java.util.function.*;

public class JdkFunctionTest {

    public static void main(String[] args) {

        Supplier<String> supplier = () -> "aaa";
        System.out.println(supplier.get());

        Consumer<String> consumer = s -> System.out.println("accept" + s);
        consumer.accept("consumer");

        Function<Integer, Integer> function = i -> i * i;
        System.out.println(function.apply(1));

        UnaryOperator<Integer> unaryOperator = i -> i * i;
        System.out.println(unaryOperator.apply(1));

        BiFunction<Integer, Integer, String> biFunction = (i, j) -> i * j + "";
        System.out.println(biFunction.apply(1, 2));
    }
}
