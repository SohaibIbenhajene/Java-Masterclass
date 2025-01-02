package dev.sohaib;

import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        int[] array = {4, 6, 3, 9, 12};
        System.out.println(Arrays.toString(array));
        int[] reversedArray = reverse(array);
        System.out.println(Arrays.toString(reversedArray));
    }

    public static int[] reverse(int[] array) {
        int[] reversedArray = new int[array.length];
        int i = array.length - 1, j = 0;
        while (i >= 0) {
            reversedArray[j] = array[i];
            i--;
            j++;
        }
        return reversedArray;
    }

//    More efficient
//    public static void reverse(int[] array) {
//        int maxIndex = array.length - 1;
//        int halfLength = array.length / 2;
//        for (int i = 0; i < halfLength; i++) {
//            int temp = array[i];
//            array[i] = array[maxIndex - i];
//            array[maxIndex - i] = temp;
//        }
//    }
}
