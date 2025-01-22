package lesson6;

import java.math.BigDecimal;
import java.util.Arrays;

public class AccountRunner {

    public static void main(String[] args) throws Exception {
        Account account = new Account(BigDecimal.ZERO) {
            @Override
            public void deposit(long money) {

            }
        };

        int[] value = {100, 200, 300};

        RussianPersonalAccount personalAccount = new RussianPersonalAccount(BigDecimal.TEN, value);
        PersonalAccount personalAccount2 = new RussianPersonalAccount(BigDecimal.TEN, value);
//        personalAccount = personalAccount2;

        int[] intArray = {1, 3, 5};
        System.out.println(intArray);

        Account[] accounts = {account, personalAccount};
        System.out.println(accounts);

       System.out.println(personalAccount == personalAccount2);

        System.out.println(personalAccount2.equals(personalAccount));

        Object personalAccount3 = ((RussianPersonalAccount)personalAccount).clone();
        System.out.println(
                ((RussianPersonalAccount) personalAccount).getArray() == ((RussianPersonalAccount) personalAccount3).getArray());

        System.out.println(Arrays.toString(((RussianPersonalAccount) personalAccount).getArray()));
        System.out.println(Arrays.toString(((RussianPersonalAccount) personalAccount3).getArray()));

        System.out.println("-----");
        RussianPersonalAccount personalAccount4 = new RussianPersonalAccount(personalAccount);
        System.out.println(
                personalAccount.getArray() == personalAccount4.getArray());

        System.out.println(Arrays.toString(personalAccount.getArray()));
        System.out.println(Arrays.toString( personalAccount4.getArray()));

//        RussianPersonalAccount personalAccount4 = new RussianPersonalAccount(personalAccount);
//        System.out.println(personalAccount.array == personalAccount4.array);
    }
}
