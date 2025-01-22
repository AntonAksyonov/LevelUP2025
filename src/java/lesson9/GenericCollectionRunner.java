package lesson9;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class GenericCollectionRunner {
    public static void main(String[] args) {
//        List<Account> accountList = new LinkedList<>();
        List<? super Account> accountList = new LinkedList<>();
        add(accountList);

        List<? extends Account> accounts = new LinkedList<>();
        print(accounts);
//        accountList.add(new CorporateAccount(BigDecimal.ZERO, "346549845165"));
//        accountList.add(new Account(BigDecimal.ONE, "3465498w45165"));
//        accountList.add(new Account(BigDecimal.TWO, "3465498451ger65"));
//        accountList.add(new PersonalAccount(new BigDecimal("246584"), "3465498w4516e5"));
//        accountList.add(new Account(new BigDecimal("1001"), "3465498w4516t5"));

        System.out.println(accountList);

        CorporateAccount x = (CorporateAccount) accountList.get(0);
        System.out.println(x);
    }
    // PECS
    public static void print(List<? extends Account> accounts) {

        Account account = accounts.get(0);
        System.out.println(account);
    }

    public static void add(List<? super Account> accounts) {
        accounts.add(new CorporateAccount(BigDecimal.ZERO, "346549845165"));
        accounts.add(new Account(BigDecimal.ONE, "3465498w45165"));
        accounts.add(new Account(BigDecimal.TWO, "3465498451ger65"));
        accounts.add(new PersonalAccount(new BigDecimal("246584"), "3465498w4516e5"));
        accounts.add(new Account(new BigDecimal("1001"), "3465498w4516t5"));
    }
}
