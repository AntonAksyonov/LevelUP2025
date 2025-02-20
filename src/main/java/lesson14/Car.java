package lesson14;

import static lesson14.Car.MODEL_YEAR;

//@Serializable(value = MODEL_YEAR, model = "", names = {"Test", "Test2"})
@Serializable(value = MODEL_YEAR, model = "", flag = true, names = {"Test", "Test2"})
public class Car {

    public static final int MODEL_YEAR = 2000;
}