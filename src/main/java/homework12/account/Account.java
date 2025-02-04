package homework12.account;

import homework12.client.Client;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Account implements HasDeposit, Withdrawable {
    private String accountNumber;
    private BigDecimal balance;
    private LocalDateTime openedAt;
    private LocalDateTime closedAt;
    private Client owner;

    @Override
    public void deposit(BigDecimal money) {
        this.balance = this.balance.add(money);
    }

    @Override
    public void withdraw(BigDecimal money) {
        this.balance = this.balance.subtract(money);
    }
}
