package dev.sohaib;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        arrayListProgram();
        Scanner scanner = new Scanner(System.in);
    }

    public static void arrayListProgram() {
        ArrayList<String> groceryList = new ArrayList<>();
        int action = -1;
        while (action != 0) {
            System.out.print("""
                    Available actions:
                    0 - to shutdown
                    1 - to add item(s) to list (comma delimited list)
                    2 - to remove any items (comma delimited list)
                    Enter a number for which action you want to do: """);
            try {
                action = Integer.parseInt(scanner.nextLine());
                if (action != 1 && action != 2 && action != 0) {
                    System.out.println("You must enter one of the three options!");
                    continue;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("You must enter one of the three options!");
                continue;
            }

            switch (action) {
                case 1 -> addItem(groceryList);
                case 2 -> removeItem(groceryList);
            }
            groceryList.sort(Comparator.naturalOrder());
            System.out.println(groceryList);
        }
    }

    public static void addItem(ArrayList<String> groceryList) {
        System.out.println("Enter a comma delimited list of items you want to add.");
        String groceryString = scanner.nextLine();
        String[] groceryArray = groceryString.split(",");
        for (String grocery: groceryArray) {
            String trimmed = grocery.trim();
            if (!groceryList.contains(trimmed)) {
                groceryList.add(trimmed);
            }
        }
    }

    public static void removeItem(ArrayList<String> groceryList) {
        System.out.println("Enter a comma delimited list of items you want to remove.");
        String removeString = scanner.nextLine();
        String[] removeArray  = removeString.split(",");
        for (String remove: removeArray) {
            String trimmed = remove.trim();
            groceryList.remove(trimmed);
        }
    }
}
