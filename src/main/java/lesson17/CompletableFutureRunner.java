package lesson17;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureRunner {

    public static void main(String[] args) throws Exception {
        CompletableFuture.completedFuture("Hello")
                .thenApply(result -> {
                    if (true) {
                        throw new NullPointerException();
                    }
                    return result + " Vitaly";
                })
                .exceptionally(th -> "")
                .thenAccept(result -> {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Text " + result);
                    }
                }).get();
//        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println("Text " + i);
//            }
//            return null;
//        });
    }
}