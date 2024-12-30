import java.util.Scanner;

public class ReadingUserInput {
    public static void main(String[] args) {
        int numberCounter = 1, enteredNumber = 0, sum = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter number #" + numberCounter + ": ");
            try {
                enteredNumber = Integer.parseInt(scanner.nextLine());
                sum += enteredNumber;
                numberCounter++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }

        } while (numberCounter <= 5);

        System.out.println(sum);
    }
}
