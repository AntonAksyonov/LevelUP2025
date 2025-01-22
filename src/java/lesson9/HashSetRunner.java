package lesson9;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashSetRunner {
    public static void main(String[] args) {
//        Set<Account> accounts = new HashSet<>(5);
        Set<Account> accounts = new LinkedHashSet<>(5);
        accounts.add(new Account(BigDecimal.ZERO, "346549845165"));
        accounts.add(new Account(BigDecimal.ONE, "3465498w45165"));
        accounts.add(new Account(BigDecimal.TWO, "3465498451ger65"));
        accounts.add(new Account(new BigDecimal("246584"), "3465498w4516e5"));
//        accounts.add(new Account(new BigDecimal("1000"), "3465498w4516e5"));
        accounts.add(new Account(new BigDecimal("1001"), "3465498w4516t5"));

        System.out.println(accounts);
        System.out.println(accounts.size());

        accounts.clear();
    }
}
