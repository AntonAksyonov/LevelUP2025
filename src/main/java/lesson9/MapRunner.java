package lesson9;

import lesson6.InterfaceRunner;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MapRunner {
    public static void main(String[] args) {
//        Map<Integer, String> cityMap = new HashMap<>();
        Map<Integer, String> cityMap = new TreeMap<>();
        cityMap.put(77, "Москва");
        cityMap.put(78, "Спб");
        cityMap.put(63, "Самара");
        cityMap.put(64, null);
        cityMap.put(34, "Волгоград");
        cityMap.put(50, "Московская область");
        cityMap.put(55, "Оренбургская");
//        cityMap.put(null, "Несуществующая область");

        System.out.println(cityMap);


        System.out.println(cityMap.get(63));
        System.out.println(cityMap.get(64));
        System.out.println(cityMap.getOrDefault(65, "Несуществующая область"));

//        if (ityMap.get(64) != null) { не всегда будет работать корректно
        if (cityMap.containsKey(64)) {
            System.out.println("Строка с ключом 64 найдена");
        }

//        for (Map.Entry<Integer, String> entry : cityMap.entrySet()) {
//            System.out.println("Ключ : %d Значение : %s".formatted(entry.getKey(), entry.getValue()));
//        }

        for (Integer key : cityMap.keySet()) {
            System.out.println("Ключ : %d Значение : %s".formatted(key, cityMap.get(key)));
        }

        Map<Account, BigDecimal> accountBalances = new TreeMap<>(new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return -o1.getBalance().compareTo(o2.getBalance());
            }
        });
        Account key = new Account(BigDecimal.ZERO, "6545655");
        accountBalances.put(key, BigDecimal.ZERO);
        accountBalances.put(new Account(BigDecimal.ZERO, "6545655"), BigDecimal.ZERO);
        accountBalances.put(new Account(BigDecimal.ONE, "6545f655"), BigDecimal.ONE);
        accountBalances.put(new Account(BigDecimal.TWO, "65f45655"), BigDecimal.TWO);
        accountBalances.put(new Account(BigDecimal.TEN, "654f5655"), BigDecimal.TEN);
        accountBalances.put(new Account(new BigDecimal("100"), "6545655"), new BigDecimal("100"));

        System.out.println(accountBalances);

        accountBalances.putIfAbsent(key, BigDecimal.TEN);
        accountBalances.remove(key);
        System.out.println(accountBalances);
    }
}
