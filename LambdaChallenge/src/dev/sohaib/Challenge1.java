package dev.sohaib;

import java.util.Arrays;
import java.util.function.Consumer;

public class Challenge1 {
    public static void main(String[] args) {
        Consumer<String> printWordsLambda = sentence -> {
            String[] parts = sentence.split(" ");
            for (String part: parts) {
                System.out.println(part);
            }
        };

        printWordsLambda.accept("Let's split this up into an array");

        Consumer<String> printWordsForEach = sentence -> {
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach(s -> System.out.println(s));
        };

        printWordsForEach.accept("Let's split this up into an array");

        Consumer<String> printWordsConcise = sentence -> {
            Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));
        };

        printWordsConcise.accept("Let's split this up into an array");
    }
}
