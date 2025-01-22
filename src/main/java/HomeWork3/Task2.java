package HomeWork3;

public class Task2 {
    public static void main(String[] args) {
        boolean simpleNumber = false;
        int quantity = 0;
        int quantityAll = 0;
        System.out.print("Простые числа: ");
        for (int number = 1; number <= 10000; number++) {
            simpleNumber = true;
            for (int divider = 2; divider <= (number / 2); divider++) {
                if (number % divider == 0) {
                    simpleNumber = false;
                    break;
                }
            }
            if (simpleNumber) {
                quantity++;
                quantityAll++;
                System.out.print((quantityAll != 1? ", " : "") + number);
                if (quantity == 25) {
                    quantity = 0;
                    System.out.println();
                }
            }
        }
        System.out.println();
        System.out.print("всего " + quantityAll);
    }
}
