package lesson6;

import java.math.BigDecimal;

public class PersonalAccount extends Account {
    public PersonalAccount(int month, BigDecimal balance) {
        super(balance);
        System.out.println("Открываем лицевой счет");
        int treshHold = 100;
    }

    public PersonalAccount() {
        this(3, BigDecimal.ZERO);
    }

    @Override
    public void withdraw(long money) {
//        if
        super.withdraw(money);
    }

    public void deposit(long money) {

    }

    @Override
    public int hashCode() {
        int koeff = 7;

        return koeff * balance.hashCode();// + field.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        PersonalAccount personalAccount = (PersonalAccount) obj;
        return personalAccount.balance.equals(this.balance);
    }
}
