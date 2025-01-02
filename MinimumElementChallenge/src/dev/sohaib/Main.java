package dev.sohaib;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = readIntegers();
        System.out.println(Arrays.toString(array));
        int minNum = findMin(array);
        System.out.println("Minimum number in array: " + minNum);
    }

    public static int[] readIntegers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a comma delimited list e.g(1,2,3,4):");
        String numbersString = scanner.nextLine();

        String[] stringArray = numbersString.split(",");
        int[] numberArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            numberArray[i] = Integer.parseInt(stringArray[i].trim());
        }
        return numberArray;
    }

    public static int findMin(int[] array) {
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
