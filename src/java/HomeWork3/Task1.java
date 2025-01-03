package HomeWork3;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        char[] arrayChars = new char[]{'H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd'};
        for (int i = 0; i < arrayChars.length; i++) {
            System.out.print(arrayChars[i]);
        }
        System.out.println();

        for (char char_ : arrayChars) {
            System.out.print(char_);
        }
        System.out.println();

        int i = 0;
        while (i < arrayChars.length){
            System.out.print(arrayChars[i]);
            i++;
        }
        System.out.println();

        i = 0;
        do {
            System.out.print(arrayChars[i]);
            i++;
        } while (i < arrayChars.length);
    }
}
