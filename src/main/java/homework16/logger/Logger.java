package homework16.logger;

import lombok.RequiredArgsConstructor;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

@RequiredArgsConstructor
public class Logger extends Thread {
    public static final String SRC_RESOURCES_LOG = "src/main/resources/homework16.log";

    private static final Object lock = new String();

    private final LoggingStatus loggingLevel;
    private final String message;

    @Override
    public synchronized void run() {
        try {
            while (!isInterrupted()) {
                int millisSleep = new Random().nextInt(5000);
                Thread.sleep(millisSleep);
                try (FileWriter fileWriter = new FileWriter(SRC_RESOURCES_LOG, true)) {
                    fileWriter.write("%s %s %s %s%s".formatted(LocalDateTime.now().toString(), loggingLevel.name(), Thread.currentThread().threadId(), message, "\n"));
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            System.out.println("У потока %s при работе с файлом %s возникла ошибка %s".formatted(Thread.currentThread().threadId(), SRC_RESOURCES_LOG, e.getMessage()));
        }
    }
}
