package dev.sohaib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static Random random = new Random();

    public static void main(String[] args) {
        String[] names = {"Anna", "jodie", "Margit", "Helen", "bianca"};
        System.out.println(Arrays.toString(names));
        Arrays.setAll(names, s -> names[s].toUpperCase());
        System.out.println(Arrays.toString(names));

        List<String> backedByArray = Arrays.asList(names);

        backedByArray.replaceAll(s -> s += " " + getRandomChar('A', 'D') + ".");
        System.out.println(Arrays.toString(names));

        backedByArray.replaceAll(s -> s += " " + getReverseName(s.split(" ")[0]));
        backedByArray.forEach(s -> System.out.println(s));

        List<String> newList = new ArrayList<>(Arrays.asList(names));
        newList.removeIf(s -> s.split(" ")[0].equals(s.split(" ")[2]));
        newList.forEach(s -> System.out.println(s));

    }

    public static char getRandomChar(char startChar, char endChar) {
        return (char) random.nextInt((int) startChar, (int) endChar + 1);
    }

    private static String getReverseName(String firstName) {
        return new StringBuilder(firstName).reverse().toString();
    }
}
