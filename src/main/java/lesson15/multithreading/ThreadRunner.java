package lesson15.multithreading;

public class ThreadRunner {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello (%s)".formatted(Thread.currentThread().threadId()));
        PrintThread thread1 = new PrintThread("RUNNING");
//        thread1.setPriority(Thread.MAX_PRIORITY);
        Thread thread2 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(5000);
                    Thread.State state = Thread.currentThread().getState();
//                    Thread.currentThread().yield();
                    System.out.println("Author: Vitalii (%s)".formatted(Thread.currentThread().threadId()));
                } catch (InterruptedException e) {
                    // закрытие сессий
                    Thread.currentThread().interrupt();
                } catch (Exception e) {

                }
            }
        });
//        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.start();
        thread2.join();

        thread1.setDaemon(true);
        thread1.start();
        thread1.join();
        thread1.interrupt();
//        thread1.stop(); // использовать ни в коем случае нельзя
    }
}