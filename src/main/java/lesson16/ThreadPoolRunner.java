package lesson16;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadPoolRunner {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public static void main(String[] args) throws Exception {
        long time = System.currentTimeMillis();
        System.out.println("Программа начала свою работу %s".formatted(DATE_TIME_FORMATTER.format(LocalDateTime.now())));
        try (ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
             ExecutorService threadPoolOf10Threads = Executors.newVirtualThreadPerTaskExecutor()//Executors.newFixedThreadPool(10);
        ) {

//            int deadlineInSeconds = 2;
            Future<Integer> future = threadPoolOf10Threads.submit(() -> {
//                long currentTime = System.currentTimeMillis();
                for (int i = 1; i <= 10; i++) {
//                    if (System.currentTimeMillis() - currentTime > deadlineInSeconds * 1000) {
//                        Thread.currentThread().interrupt();
//                        return -1;
//                    }
                    Thread.sleep(i * 1000);
                }
                return 1;
            });
            Integer result = null;
            try {
                result = future.get(1, TimeUnit.SECONDS);
                System.out.println("Результат = %d и потраченное время = %dмсек".formatted(result, System.currentTimeMillis() - time));
            } catch (TimeoutException te) {
                System.out.println("Не дождались получения результата!");
                future.cancel(true);
            }
        }

        System.out.println("Программа завершила свою работу %s".formatted(DATE_TIME_FORMATTER.format(LocalDateTime.now())));

    }
}