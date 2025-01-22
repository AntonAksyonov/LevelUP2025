package lesson5.account.legal;

import lesson5.account.Account;

import java.math.BigDecimal;

public class LegalAccount extends Account {
    private String organization;

    public LegalAccount(String organization) {
        this.organization = organization;
        setCommission(new BigDecimal("0.05"));
        setThreshold(new BigDecimal("300000"));
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
    @Override
    public void withdraw(BigDecimal money) {
        if (organization.equals("SuperPuper")) {
            this.balance = this.balance.subtract(money);
//            this.setBalance(this.getBalance().subtract(money));
        } else {
            super.withdraw(money);
        }
    }

    @Override
    public String toString() {
        return "LegalAccount{" +
                "organization='" + organization + '\'' +
                '}';
    }
}
