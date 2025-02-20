package lesson15.multithreading;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
@RequiredArgsConstructor
public class PrintThread extends Thread implements Runnable {
    private final String status;
    @Override
    @SneakyThrows
    public void run() {
        while (!isInterrupted()) {
            Thread.sleep(5000);
            System.out.println("Status %s, To: World (%s)".formatted(status, Thread.currentThread().threadId()));
        }
    }
}