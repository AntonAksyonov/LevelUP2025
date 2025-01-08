package lesson5.account;

import java.math.BigDecimal;

public class PersonalAccount extends Account {
    private String fullName;

    public PersonalAccount(String fullName) {
        this.fullName = fullName;
        setCommission(new BigDecimal("0.01"));
        setThreshold(new BigDecimal("100000"));
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void deposit(BigDecimal money) {
        this.setBalance(this.getBalance().add(money));
    }

//    public void withdraw(BigDecimal money) {
//        if (money.compareTo(new BigDecimal("100000")) > 0) {
//            money = money.add(money.multiply(new BigDecimal("0.01")));
//        }
//        this.setBalance(this.getBalance().subtract(money));
//    }

    @Override
    public String toString() {
        return "PersonalAccount{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}
