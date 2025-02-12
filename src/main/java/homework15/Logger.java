package homework15;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Random;

@RequiredArgsConstructor
public class Logger extends Thread implements Runnable {
    public static final String SRC_RESOURCES_LOG = "src/main/resources/homework15.log";

    private final LoggingStatus loggingLevel;
    private final String message;

    @Override
    @SneakyThrows
    public void run(){
        try {
            while (!isInterrupted()) {
                int millisSleep = new Random().nextInt(5000);
                Thread.sleep(millisSleep);
                try (FileWriter fileWriter = new FileWriter(SRC_RESOURCES_LOG, true)) {
                    fileWriter.write("%s %s %s %s%s".formatted(LocalDateTime.now().toString(), loggingLevel.name(), Thread.currentThread().threadId(), message, "\n"));
                }
            }
        } catch (InterruptedException e){

        }
    }
}
