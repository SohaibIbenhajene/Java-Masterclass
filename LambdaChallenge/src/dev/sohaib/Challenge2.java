package dev.sohaib;

import java.util.function.UnaryOperator;

public class Challenge2 {
    public static void main(String[] args) {
        UnaryOperator<String> everySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(everySecondChar.apply("1234567890"));

        System.out.println(everySecondCharacter(everySecondChar, "1234567890"));
    }
    public static String everySecondCharacter(UnaryOperator<String> unaryOperator, String source) {
        return unaryOperator.apply(source);
    }
}
