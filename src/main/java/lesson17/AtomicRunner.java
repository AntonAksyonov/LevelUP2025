package lesson17;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicRunner {

    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(1);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(counter.incrementAndGet());
//                counter.set(counter.addAndGet(1));
                }
            });
            if (new Random().nextBoolean()) {
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(counter.decrementAndGet());
//                counter.set(counter.addAndGet(1));
                    }
                });
            }
        }

        System.out.println("Результат: " + counter.get());
        executorService.shutdownNow();
    }
}