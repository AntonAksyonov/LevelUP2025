package lesson10;

import lesson4.Account;
import lesson4.Client;

import java.util.Optional;
import java.util.function.Function;

public class OptionalRunner {
    public static void main(String[] args) {
//        Account account = new Account("125445", "RUR", new Client());
        Account account = null;
//        Optional<Account> optional = Optional.of(account)
        Optional<Account> optional = Optional.ofNullable((account));
        String accountNumber = account == null? null:account.getAccountNumber();
        Optional<String> accountNumberOptional = optional.map(it -> it.getAccountNumber());
        String accountNumber2 = optional.map(it -> it.getAccountNumber()).orElse(null); // Optional<Strinc>
        String s1 = accountNumberOptional.orElse(test());
        String s2 = accountNumberOptional.or(() -> Optional.of(test())).orElse(null);
        String test = accountNumberOptional.orElseGet(() -> test());
        accountNumberOptional.filter(it -> it.matches("\\d+"));
        System.out.println(accountNumber);
        System.out.println(accountNumber2);
        String word = "Hello, Word";

        s1 = "";
        final String test2 = s1;

        Optional<Optional<String>> optionalOfOptional = Optional.of(Optional.ofNullable(word));
        Optional<String> value = optionalOfOptional.flatMap(Function.identity());
//        if (value.isPresent()) {
//        value.ifPresent(it -> {
        value.ifPresentOrElse(it -> {
            System.out.println(it);
            it = it + " again" + test2;
            System.out.println(it);
        }, () -> {
            System.out.println("Default string");
        });
        if (!value.isEmpty()) {
            System.out.println(value.get());

        } else {
            System.out.println("Default string");
        }

    }
    public static String test() {
        return "Test";
    }
}
