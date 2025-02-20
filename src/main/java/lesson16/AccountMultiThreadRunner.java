package lesson16;
public class AccountMultiThreadRunner {
    public static void main(String[] args) {
        Account sharedAccount = new Account();
        new Thread(() -> {
            try {
                System.out.println("Поток пополнения начал работу со счетом (баланс %d)".formatted(sharedAccount.getAmount()));
                for (int i = 0; i < 5; i++) {
                    sharedAccount.deposit(15);
                    System.out.println("Успешно пополнили средства на счет (баланс %d)".formatted(sharedAccount.getAmount()));
                    Thread.sleep(1500);
                }
            } catch (Exception e) {
                System.out.println("Произошла ошибка при снятии");
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println("Поток снятия начал работу со счетом (баланс %d)".formatted(sharedAccount.getAmount()));
                for (int i = 0; i < 5; i++) {
                    sharedAccount.withdraw(10);
                    System.out.println("Успешно сняли средства со счета (баланс %d)".formatted(sharedAccount.getAmount()));
                    Thread.sleep(2000);
                }
            } catch (Exception e) {
                System.out.println("Произошла ошибка при снятии");
            }
        }).start();
    }
}