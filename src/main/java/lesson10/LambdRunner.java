package lesson10;

import java.util.function.Consumer;

public class LambdRunner {
    public static void main(String[] args) {
//        Moveable moveable = new Moveable() {
//            @Override
//            public void move(int distace) {
//
//            }
//        };

//        Moveable moveable = distace -> {
//            System.out.println("Мы проехали %d киллометров".formatted(distace));
//        };

        Moveable moveable = distace -> System.out.println("Мы проехали %d киллометров".formatted(distace));
        Consumer<Integer> alternativeMoveable = distace -> System.out.println("Мы проехали %d киллометров".formatted(distace));

        moveable.move(100);
        moveable.move(1000);
        moveable.move(100500);
//        moveable.move(1000.00);

        alternativeMoveable.accept(100);
        alternativeMoveable.accept(1000);
        alternativeMoveable.accept(100500);

//        Converter converter = value -> {
//            System.out.println("Мы конвертировали значение %d".formatted(value));
//            return value;
//        };

        Converter converter = (value, coeff) -> 5;

        System.out.println(converter.convert(100L, 5));
        System.out.println(converter.convert(1000L, 50));
        System.out.println(converter.convert(100500L, -5));
//        converter.convert();
//        converter.convert();
    }
}
