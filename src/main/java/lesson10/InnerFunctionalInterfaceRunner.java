package lesson10;

import lesson4.Account;
import lesson6.InterfaceRunner;

import java.math.BigDecimal;
import java.util.Random;
import java.util.function.*;

public class InnerFunctionalInterfaceRunner {
    public static void main(String[] args) {
        Predicate<String> wordsMore2Symbols =  word -> word.length() > 2;
        Predicate<Integer> sddPredicate =  number -> number % 2 == 1;
        Predicate<Account> openPredicate =  account -> account.getValue().compareTo(BigDecimal.ZERO) >= 0;

        Predicate<Account> unclosePredicate =  account -> account.getCloseAt() == null;
        Predicate<Account> validPredicate = openPredicate.and(unclosePredicate);
        Predicate<Account> closePredicate = Predicate.not(unclosePredicate);

//        Consumer<String> stringPrinter = str -> System.out.println(str);
        Consumer<String> stringPrinter = System.out::println;
//        Consumer<Integer> numberPrinter = it -> System.out.println(it);
        Consumer<Integer> numberPrinter = System.out::println;

        Supplier<Integer> intGenerator = () -> new Random().nextInt();
        Supplier<Boolean> booleanSupplier = () -> new Random().nextBoolean();

        Function<String, Integer> sizeFunction = word -> word.length();
        Function<Integer, Integer> converterFunction = value -> value * 100;

        BiFunction<Long, Integer, Long> anotherConverterFunction = (value, coeff) -> value * coeff;

        System.out.println(anotherConverterFunction.apply(100L, 3));
    }
}
