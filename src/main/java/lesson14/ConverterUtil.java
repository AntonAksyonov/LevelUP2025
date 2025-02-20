package lesson14;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class ConverterUtil {

    Double MAX = Double.MAX_VALUE;

    int THRESHOLD = 100;

    private Random random = new Random();

//    private ConverterUtil() {}

    int convert(long value) {
//        return value == -1 ? 0 : Math.toIntExact(value);
        return Math.toIntExact(value);
    }

    int generateValue() {
        return random.nextInt(THRESHOLD);
    }
}