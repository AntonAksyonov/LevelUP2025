package HomeWork4;

public class CalculatorRunner {
    public static void main(String[] args) {
        int summandA = 3;
        int summandB = 6;
        System.out.println("%d + %d = %d".formatted(summandA, summandB, Calculator.addition(summandA, summandB)));

        long reduced = 312545231456L;
        long subtracted = 312545231457L;
        System.out.println("%d - %d = %d".formatted(reduced, subtracted, Calculator.subtraction(reduced, subtracted)));

        int multiplierA = 3;
        int multiplierB = 6;
        System.out.println("%d * %d = %d".formatted(multiplierA, multiplierB, Calculator.multiplication(multiplierA, multiplierB)));

        double divisible = 3.5D;
        double divisor = 0.5D;
        System.out.println("%1$,.10f / %2$,.10f = %3$,.10f".formatted(divisible, divisor, Calculator.separation(divisible, divisor)));

    }
}
