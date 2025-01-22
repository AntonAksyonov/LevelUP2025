package HomeWork2;

import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {
//        a*x^2 + b*x + c = 0
        int a = -30;
        int b = 5;
        int c = 1;
        double D = b * b - 4 * a * c;
        double[] arrayX = {};
        System.out.println("D = " + D);

        if (D > 0) {
            arrayX = new double[]{(-b + Math.sqrt(D) / 2 * a), (-b - Math.sqrt(D) / 2 * a)};
        } else if (D == 0) {
            arrayX = new double[]{-b / 2D * a};
        }
        System.out.println("Корни квадратного уравнения : " +
                (D >= 0 ? Arrays.toString(arrayX) : "нет действительных корней"));
    }
}
