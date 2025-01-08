package lesson5.account;

import lesson5.util.CommissionUtils;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public abstract class Account {
    private String accountNumber;
    protected BigDecimal balance;
    private ZonedDateTime openedAt;
    private BigDecimal commission;
    private BigDecimal threshold;


//    private String type;
//    private String organization;
//    private String fullName;

    public Account() {
        this.balance = new BigDecimal("0");
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setOpenedAt(ZonedDateTime openedAt) {
        this.openedAt = openedAt;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public ZonedDateTime getOpenedAt() {
        return openedAt;
    }

    public BigDecimal getThreshold() {
        return threshold;
    }

    public void setThreshold(BigDecimal threshold) {
        this.threshold = threshold;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public void deposit(BigDecimal money) {
        this.balance = this.balance.add(money);
    }

    public void withdraw(BigDecimal money) {
        this.balance = CommissionUtils.getSummaWitchCommission(this.balance, threshold, commission);
    }
}
