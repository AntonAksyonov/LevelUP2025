package homework7;

import homework7.atomobile.Automobile;

public class CallPolice {
    public CallPolice(Automobile automobile) {
        System.out.println("!Преступник на автомобиле с номером"
                + " %s пойман за существенное превышение скорости!".formatted(automobile.getNumber()));
    }
}
