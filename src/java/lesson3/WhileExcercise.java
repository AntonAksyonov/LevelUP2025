package lesson3;

public class WhileExcercise {

    public static void main(String[] args) {
        int value = 25;
        int counter = 0;
        while (value % 2 == 0) {
            if (++counter % 2 == 0) {
                value /= 2;
                continue;
            }
            System.out.println("Число " + value + " - четное");
            value /= 2;
        }
        System.out.println("Число " + value + " - нечетное");
    }
}
