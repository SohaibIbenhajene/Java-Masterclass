public class Main {
    public static void main(String[] args) {
        printDayOfWeek(7);
    }

    public static void printDayOfWeek(int day) {
        String dayOfTheWeek = switch (day) {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Invalid Day";
        };

        System.out.println("Entered day: " + day);
        System.out.println("Today's day: " + dayOfTheWeek);
    }
}