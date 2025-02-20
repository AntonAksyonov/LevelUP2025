package lesson10;

import lesson11.IntHolder;
import lesson4.Account;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;

public class OptionalRunner {

    public static void main(String[] args) {
//        Account account = new Account("132434", "RUR", new Client());
        Account account = null;
        Optional<Account> optional = Optional.ofNullable(account); // if null = Optional.empty()
        String accountNumber = account == null ? null : account.getAccountNumber();
        Optional<String> accountNumberOptional = optional.map(it -> it.getAccountNumber());
        String accountNumber2 = accountNumberOptional.isEmpty() ? null : accountNumberOptional.get();
        String s1 = accountNumberOptional.orElse(test());// Optional<String>
        String s2 = accountNumberOptional.or(() -> Optional.of(test())).orElse(null);
        String test = accountNumberOptional.orElseGet(() -> test());
        Optional<String> s = accountNumberOptional.filter(it -> it.matches("\\d+"));
        System.out.println(accountNumber);
        System.out.println(accountNumber2);
//        s1 = "";
//        final String test2 = s1;
        String word = "Hello, World";
        word += "";
        String str = word;
        AtomicInteger intHolder = new AtomicInteger(10);
        Optional<Optional<String>> optionalOfOptional = Optional.of(Optional.ofNullable(word));
        Optional<String> value = optionalOfOptional.flatMap(Function.identity());
        value.ifPresent(it -> {
            System.out.println(it);
            System.out.println(intHolder.getAndIncrement());
            it = it + " again " + s1;
            System.out.println(it);
        });

        value.ifPresentOrElse(it -> {
            System.out.println(it);
            it = it + " again " + s1;
            System.out.println(it);
        }, () -> {
            System.out.println("Default string");
        });
//        if (value.isPresent()) {
        if (!value.isEmpty()) {
            //todo
            System.out.println(value.get() + s1);
//            fadfafad
        } else {

        }
    }

    public static String test() {
        return "Test";
    }
}