package HomeWork2;

import java.util.Arrays;

public class Task3 {

    public static void main(String[] args) {
//        a*x^2 + b*x + c = 0
//        double[] arrayX = rootsQuadraticEquation(-30, 5, 1); два корня
        double[] arrayX = rootsQuadraticEquation(2, 4, 2); // один корень
//        double[] arrayX = rootsQuadraticEquation(3, 5, 10); действительных корней нет

        System.out.println("Корни квадратного уравнения : " +
                (arrayX.length != 0 ? Arrays.toString(arrayX) : "нет действительных корней"));
    }

    public static double[] rootsQuadraticEquation(int a, int b, int c) {
        double D = b * b - 4 * a * c;
        double[] arrayX = {};

        if (D > 0) {
            arrayX = new double[]{(-b + Math.sqrt(D) / 2 * a), (-b - Math.sqrt(D) / 2 * a)};
        } else if (D == 0) {
            arrayX = new double[]{-b / 2D * a};
        }

        return arrayX;
    }
}
