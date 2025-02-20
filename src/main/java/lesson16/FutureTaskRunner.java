package lesson16;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTaskRunner {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public static void main(String[] args) throws Exception {
        System.out.println("Программа начала свою работу %s".formatted(DATE_TIME_FORMATTER.format(LocalDateTime.now())));
        long time = System.currentTimeMillis();

        Callable<Void> callable = new Callable<>() {
            @Override
            public Void call() throws Exception {
                Thread.sleep(10000);
//                for (;;) {
//
//                }
//                wait(1000);
//                return 0;
                return null;
            }
        };

        FutureTask<Void> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
//        futureTask.run();

//        Integer result = futureTask.get();
        Object result = "test";
//        while(!futureTask.isDone()) {
//            System.out.println("задача продолжает свое выполнение");
//            Thread.sleep(100);
//        }
        try {
            result = futureTask.get(1, TimeUnit.SECONDS);
        } catch (Exception e) {
            futureTask.cancel(true);
            result = "Exception";
        }

        System.out.println("Результат = %s и потраченное время = %dмсек".formatted(result, System.currentTimeMillis() - time));

        System.out.println("Программа завершила свою работу %s".formatted(DATE_TIME_FORMATTER.format(LocalDateTime.now())));
    }
}