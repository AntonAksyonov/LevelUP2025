package lesson3;

import java.util.Arrays;

public class ArrayExcercise {
    public static void main(String[] args) {
//        String[] arrayOfWords = {"Hello" , "World"};
        String[] arrayOfWords = new String[]{"Hello" , "World"};
//        String[] arrayOfWords = new String[2];
//        arrayOfWords[0] = "Hello";
//        arrayOfWords[1] = "World";
//        for(int i = 0; i < arrayOfWords.length; i++) {
        for ( String word : arrayOfWords){
              System.out.println(word);
//            System.out.println(arrayOfWords[i]);
        }
        System.out.println(Arrays.toString(arrayOfWords));
        //System.out.println(arrayOfWords);

        int[][] matrixA = new int[3][3];
        matrixA[0][0] = 1;
        matrixA[0][1] = 0;
        matrixA[0][2] = 3;
        matrixA[1][0] = -1;
        matrixA[1][1] = 18;
        matrixA[1][2] = 20;
        matrixA[2][0] = 17;
        matrixA[2][1] = 18;
        matrixA[2][2] = 18;
        for (int k = 0; k < matrixA.length; k++) {
            for (int l = 0; l < matrixA[k].length; l++) {
                System.out.print(matrixA[k][l] + " ");
            }
            System.out.println();
        }
    }
}
