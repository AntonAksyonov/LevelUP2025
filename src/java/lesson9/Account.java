package lesson9;

import java.math.BigDecimal;

public class Account /*implements Comparable*/{

    private String accountNumber;
    private BigDecimal balance;

    public Account(BigDecimal balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    @Override
    public int hashCode() {
        return accountNumber.hashCode();
//        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Account account) {
            return account.accountNumber.equals(this.accountNumber);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }


}
