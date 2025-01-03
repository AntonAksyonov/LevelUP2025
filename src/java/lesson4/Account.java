package lesson4;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Account {
    static int counter;
    private String accountNumber;
    private String currency;
//    LocalDateTime openedAt = LocalDateTime.now();
    private LocalDateTime openedAt;
    // здесь мог быть null
    private LocalDateTime closeAt;
//    String state = "OPENED";
    private String state;
//    BigDecimal value = BigDecimal.ZERO;
    private BigDecimal value;
    private Client client;

    public Account() {
        this.openedAt = LocalDateTime.now();
        this.state = "OPEN";
        this.value = BigDecimal.ZERO;
        this.counter++;
    }

    public Account(String accountNumber, String currency, Client client) {
//        this.openedAt = LocalDateTime.now();
//        this.state = "OPENED";
//        this.value = BigDecimal.ZERO;
        this();

        this.accountNumber = accountNumber;
        this.currency = currency;
        this.client = client;
    }

    public void deposit(BigDecimal money) {
        this.value = this.value.add(money);
    }

    private BigDecimal getComvission(BigDecimal money) {
        if ("RUR".equals(currency) && money.compareTo(new BigDecimal("100000")) > 0) {
            return money.multiply(new BigDecimal("0.01"));
        }
        return BigDecimal.ZERO;
    }

    public void withdraw(BigDecimal money) {
        money = money.add(getComvission(money));
        if (this.value.compareTo(money) >= 0) {
            this.value = this.value.subtract(money);
        } else {
            System.out.println("Сумма снятия больше остатка на счёте");
        }

//        deposit(money.multiply(new BigDecimal("-1")));
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

//    public String toString() {
//        return "Hello";
//    }

    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", currency='" + currency + '\'' +
                ", openedAt=" + openedAt +
                ", closeAt=" + closeAt +
                ", state='" + state + '\'' +
                ", value=" + value +
                ", client=" + client +
                '}';
    }
}
