package lesson4;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AccountRunner {
    public static void main(String[] args) {
        Client client = new Client();
        client.setFio("Aksyonov Anton Nikolaevich");
        client.setBirthdate(LocalDate.of(1988, 7, 13));
        Account aksyonovANAccount = new Account("32454845854748", "RUR", client);
        System.out.println("Текущий остаток " + aksyonovANAccount.getValue() + " на счете " + aksyonovANAccount.getAccountNumber());
        aksyonovANAccount.deposit(BigDecimal.valueOf(1000));
        aksyonovANAccount.deposit(BigDecimal.valueOf(110000));
        System.out.println("Текущий остаток на счете " + aksyonovANAccount.getValue());
        aksyonovANAccount.withdraw(BigDecimal.valueOf(500));
        aksyonovANAccount.withdraw(BigDecimal.valueOf(100001));
        System.out.println("Текущий остаток на счете " + aksyonovANAccount.getValue());
        System.out.println(aksyonovANAccount);


        Client petrov = new Client();
        petrov.fio = "Petrov Petr Nikolaevich";
        petrov.birthdate = LocalDate.of(2000, 1, 1);
        Account petrovPetrANAccount = new Account("32454845854749", "EUR", petrov);
        System.out.println("Текущий остаток на счете " + petrovPetrANAccount.getValue());

        Account petrovPetrANAccount2 = new Account("3e2454845854749", "RUB", petrov);
        System.out.println("Текущий остаток на счете " + petrovPetrANAccount2.getValue());

        Account newAccount = new Account();
//        newAccount.accountNumber = "46565484978";
        System.out.println(newAccount);
        System.out.println(aksyonovANAccount);

        System.out.println(aksyonovANAccount == petrovPetrANAccount);

        System.out.println("Текущее количество открытых счетов " + Account.counter);
    }
}
