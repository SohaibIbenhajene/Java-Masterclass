package dev.sohaib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Anna", "Jodie", "Margit", "Helen", "Bianca", "Andrew", "Michael"));

        List<UnaryOperator<String>> interfaceList = new ArrayList<>();
        interfaceList.add(String::toUpperCase);

        Supplier<Random> random = Random::new;
        interfaceList.add(s -> s + " " + s.charAt(random.get().nextInt(s.length() -1)));

        interfaceList.add(s -> {
            StringBuilder stringBuilder = new StringBuilder(s.split(" ")[0]);
            return s + " " + stringBuilder.reverse();
        });

        transformStrings(names, interfaceList);
    }

    public static void transformStrings(List<String> names, List<UnaryOperator<String>> interfaceList) {
        for (var function: interfaceList) {
            names.replaceAll(function);
            System.out.println(names);
        }
    }
}
