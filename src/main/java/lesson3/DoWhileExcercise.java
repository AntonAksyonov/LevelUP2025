package lesson3;

public class DoWhileExcercise {
    public static void main(String[] args) {
        int value = 25;
        int counter = 0;
        do {
            if (counter++ % 2 != 0) {
                value /= 2;
                continue;
            }
            System.out.println("Число " + value + " - четное");
            value /= 2;

        } while (value % 2 == 0);
        System.out.println("Число " + value + " - нечетное");
    }
}
