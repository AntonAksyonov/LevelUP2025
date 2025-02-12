package homework15;

public class LoggerRunner {

    public static final int WAIT = (60 * 1000);

    public static void main(String[] args) {

        Thread thread1 = new Logger(LoggingStatus.INFO, "поток выводит в лог");
        Thread thread2 = new Logger(LoggingStatus.ERROR, "поток выводит в лог");
        Thread thread3 = new Logger(LoggingStatus.WARN, "поток выводит в лог");

        thread1.start();
        thread2.start();
        thread3.start();

        long startTime = System.currentTimeMillis();
        long endTime = startTime;
        while (endTime - startTime < WAIT) {

            endTime = System.currentTimeMillis();
        }

        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
    }
}
