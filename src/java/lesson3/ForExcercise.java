package lesson3;

public class ForExcercise {
    public static void main(String[] args) {
        int summa = 0;
        for (int i = 0; i < 5; i++){
            summa = summa + i * 100;
        }
        System.out.println(summa);
        System.out.println(factorial(20));
        System.out.println(factorialWithRecursion(5));
    }

    public static long factorial(int value) {
        long result = 1;
        for (int i = 1; i <= value; i++){
            result *= i;
        }
        return result;
    }

    public static long factorialWithRecursion(int value) {
        if (value == 1 || value == 2) {
            return value;
        }
        return value * factorialWithRecursion(value - 1);
    }
}
