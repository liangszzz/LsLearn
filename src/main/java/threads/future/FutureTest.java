package threads.future;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class FutureTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(1);

        Future<String> future = pool.submit(() -> "abc");

        System.out.println(future.get());

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "aaaa", pool);

        future1.thenApply(String::toUpperCase).thenApply((str) -> str + "bbb").thenAccept(System.out::println);

        pool.shutdown();
    }
}
