package HomeWork3;

public class Task3 {
    public static void main(String[] args) {
        int result = 0;
        int number = 17;
        for (int i = 1; i <= number / 2; i++) {
            if (i * i == number) {
                result = i;
                break;
            }
        }
        System.out.println(result != 0 ? "Натуральный корень из числа %d равен %d".formatted(number, result)
                : "Нет натурального корня из числв %d".formatted(number));
    }
}
