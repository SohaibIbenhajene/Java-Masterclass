import java.util.Scanner;

public class MinAndMax {
    public static void main(String[] args) {
        int min = -1, max = -1, enteredNumber, loopCount = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a number or enter any character to quit:");
            try {
                enteredNumber = Integer.parseInt(scanner.nextLine());
                if (enteredNumber > max || loopCount == 0) {
                    max = enteredNumber;
                } else if (enteredNumber < min || loopCount == 0) {
                    min = enteredNumber;
                }
                loopCount++;
            } catch (NumberFormatException e) {
                break;
            }
        }

        if (loopCount > 0) {
            System.out.println("Minimum number is: " + min);
            System.out.println("Maximum number is: " + max);
        } else {
            System.out.println("No valid data entered");
        }

    }
}
