package lesson13;

import java.math.BigDecimal;

public class LegalAccount extends Account{

//    private BigDecimal balance;
    @NotNull
    private String organization;

    public LegalAccount(BigDecimal balance, String organization) {
        super(balance);
        this.organization = organization;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void withdraw(BigDecimal bigDecimal) {
        this.balance = this.getBalance().subtract(bigDecimal);
    }
}
