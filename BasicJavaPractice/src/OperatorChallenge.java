public class OperatorChallenge {
    public static void main(String[] args) {
        System.out.println(getDurationString(3945));
    }

    public static String getDurationString(int seconds) {
        if (seconds < 0) {
            return "Seconds cannot be negative";
        }

        return getDurationString(seconds / 60, seconds % 60);
    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes < 0) {
            return "Minutes be negative";
        }

        if (seconds < 0 || seconds > 59) {
            return "Seconds must be between 0 and 59";
        }

        int hours = minutes / 60;
        minutes %= 60;

        return hours + "h " + minutes + "m " + seconds + "s";
    }
}
