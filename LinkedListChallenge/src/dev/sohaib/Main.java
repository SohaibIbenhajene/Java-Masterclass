package dev.sohaib;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<Place> list = new LinkedList<>();
        addPlace(new Place("Sydney", 0), list);
        addPlace(new Place("Adelaide", 1374), list);
        addPlace(new Place("adelaide", 1374), list);
        addPlace(new Place("Alice Springs", 2771), list);
        addPlace(new Place("Brisbane", 917), list);
        addPlace(new Place("Darwin", 3972), list);
        addPlace(new Place("Melbourne", 877), list);
        addPlace(new Place("Perth", 3923), list);
        sortList(list);
        linkedListProgram(list);
    }

    private static void linkedListProgram(LinkedList<Place> list) {
        var iteratorList = list.listIterator();
        String menu = ("""
                    Available actions (select word or letter):
                    (F)orward
                    (B)ackward
                    (L)ist Places
                    (M)enu
                    (Q)uit""");
        Scanner scanner = new Scanner(System.in);
        String action = " ";
        boolean movingForward = true;
        System.out.println(menu);
        while (!"Quit".contains(action)) {
            System.out.print("Enter a value: ");
            action = scanner.nextLine().toUpperCase().substring(0, 1);
            switch (action) {
                case "F" -> {
                    if (!movingForward && iteratorList.hasNext()) {
                        iteratorList.next();
                    }
                    movingForward = true;
                    forwardOrBackward(iteratorList, movingForward);
                }
                case "B" -> {
                    if (movingForward && iteratorList.hasPrevious()) {
                        iteratorList.previous();
                    }
                    movingForward = false;
                    forwardOrBackward(iteratorList, movingForward);
                }
                case "L" -> System.out.println(list);
                case "M" -> System.out.println(menu);
            }
        }
    }

    private static void forwardOrBackward(ListIterator<Place> iteratorList, boolean isForward) {
        if (isForward && iteratorList.hasNext()) {
            System.out.println(iteratorList.next());
        } else if ((!isForward) && iteratorList.hasPrevious()) {
            System.out.println(iteratorList.previous());
        } else {
            System.out.println("There are no elements left towards the " + ((isForward) ? "end" : "start"));
        }
    }

    private static void addPlace(Place place, LinkedList<Place> list) {
        if (list.contains(place)) {
            System.out.println("Place already in the list: " + place);
        } else if (findPlace(place.getTown(), list)) {
            System.out.println("Place already in the list: " + place);
        } else {
            list.add(place);
        }
    }

    private static boolean findPlace(String place, LinkedList<Place> list) {
        for (Place value : list) {
            if (value.getTown().equalsIgnoreCase(place)) {
                return true;
            }
        }
        return false;
    }

    private static void sortList(LinkedList<Place> list) {
        Comparator<Place> comparator = (p1, p2) -> Integer.compare(p1.getDistanceFromStart(), p2.getDistanceFromStart());
        list.sort(comparator);
    }
}
