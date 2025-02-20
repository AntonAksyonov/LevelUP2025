package lesson13;

import java.math.BigDecimal;

public abstract class Account {

    @NotNull
    protected BigDecimal balance;

    public Account(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    abstract void withdraw(BigDecimal bigDecimal);

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
