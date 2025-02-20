package lesson16;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class Account {
    //    private static final Object lock = new String();
    volatile int amount;
    public Account() {
        this(0);
    }
    public synchronized void withdraw(int value) {
//        synchronized (lock) {
//        this.amount -= value;
        this.amount = this.amount - value;
//        }
    }
    public synchronized void deposit(int value) {
        this.amount = this.amount + value;
    }
}