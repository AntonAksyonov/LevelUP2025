package homework16.logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

public class LoggerRunner {

    public static final int WAIT = 60 * 1000;

    public static void main(String[] args) throws Exception {

        System.out.println("Программа запущена");
        Thread thread1 = new Logger(LoggingStatus.INFO, "поток выводит в лог");
        Thread thread2 = new Logger(LoggingStatus.ERROR, "поток выводит в лог");
        Thread thread3 = new Logger(LoggingStatus.WARN, "поток выводит в лог");

        thread1.start();
        thread2.start();
        thread3.start();

        long startTime = System.currentTimeMillis();
        long endTime = startTime;
        long untilCompletion = 0;
        while (endTime - startTime < WAIT) {

            if (endTime != System.currentTimeMillis()) {

                endTime = System.currentTimeMillis();
                untilCompletion = WAIT - (endTime - startTime);
                if (untilCompletion % (10 * 1000) == 0) {
                    System.out.println("Осталось выполнять %s сек".formatted(untilCompletion / 1000));
                }
            }
        }
        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();

        System.out.println("Содержимое файла %s:".formatted(Logger.SRC_RESOURCES_LOG));
        try (BufferedReader fileReader = new BufferedReader(new FileReader(Logger.SRC_RESOURCES_LOG, StandardCharsets.UTF_8), 1024)) {

            fileReader.lines().forEach(System.out::println);
        }
    }
}
