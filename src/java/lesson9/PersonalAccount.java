package lesson9;

import java.math.BigDecimal;

public class PersonalAccount extends Account {
    public PersonalAccount(BigDecimal balance, String accountNumber) {
        super(balance, accountNumber);
    }

    @Override
    public String toString() {
        return "Personal: " + super.toString();
    }
}
