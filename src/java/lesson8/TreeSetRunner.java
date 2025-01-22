package lesson8;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetRunner {
    public static void main(String[] args) {
        Set<BigDecimal> values = Set.of(new BigDecimal("123"), BigDecimal.ZERO, BigDecimal.ONE);
        System.out.println(values);
        Set<BigDecimal> bigDecimals = new TreeSet<>(values);
        bigDecimals.add(BigDecimal.TEN);
//        bigDecimals.add(BigDecimal.TEN);
//        bigDecimals.add(BigDecimal.TEN);
//        bigDecimals.add(BigDecimal.TEN);
//        bigDecimals.add(BigDecimal.TEN);
        System.out.println(bigDecimals);

        Set<Car> cars = new TreeSet<>(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getMark().compareTo(o2.getMark());
            }
        });
        cars.add(new Car("Skoda", "Octavia"));
        cars.add(new Car("Audi", "A4"));
        cars.add(new Car("VW", "Tiga"));
        Car voyah = new Car("Voyah", "Free");
        cars.add(voyah);
        cars.add(new Car("BMW", "7"));

        System.out.println(cars);

        System.out.println("---");
        for (Car car: cars) {
            if (car.getModel().equals("A4")) {
                System.out.println(car);
            }
        }

        cars.remove(voyah);
        System.out.println(cars);
    }
}
