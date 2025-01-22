package HomeWork3;

import java.util.Arrays;

public class ArraySorting {

    public static void main(String[] args) {
        int[] arrayNoSort = new int[]{3, 2, 45, 89, 43, 1, 2};
        System.out.println("Несортированный массив: " + Arrays.toString(arrayNoSort));
        int[] arraySort = getSortUp(arrayNoSort);
        System.out.println("Сортированный массив: " + Arrays.toString(arraySort));
    }

    private static int[] getSortUp(int[] inArray) {
        int[] arrayForReturn = {};
        int tmp = 0;
        arrayForReturn = Arrays.copyOf(inArray, inArray.length);
        for (int i = arrayForReturn.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayForReturn[j] > arrayForReturn[j + 1]) {
                    tmp = arrayForReturn[j];
                    arrayForReturn[j] = arrayForReturn[j + 1];
                    arrayForReturn[j + 1] = tmp;
                }
            }
        }
        return arrayForReturn;
    }
}
