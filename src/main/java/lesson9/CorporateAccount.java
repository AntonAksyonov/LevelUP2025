package lesson9;

import java.math.BigDecimal;

public class CorporateAccount extends Account {
    public CorporateAccount(BigDecimal balance, String accountNumber) {
        super(balance, accountNumber);
    }

    @Override
    public String toString() {
        return "Corporate: " + super.toString();
    }
}
