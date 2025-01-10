package homework5.automobile;

public class Runner {
    public static void main(String[] args) {
        Automobile[] automobileArray = new Automobile[10];
        int wheelOfSamsara;

        for (int i = 0; i < automobileArray.length; i++) {
            wheelOfSamsara = (int) (Math.random() * 1000);
            automobileArray[i] = (wheelOfSamsara % 2 == 0) ? new Car() : new Truck();
        }

        for (Automobile automobile : automobileArray) {
            wheelOfSamsara = (int) (Math.random() * 1000);
            System.out.println(automobile.toString() + " дистанцию %d ".formatted(wheelOfSamsara)
                    + (automobile.move(wheelOfSamsara) ? "сможет" : "не сможет") + " проехать");
        }
    }
}
