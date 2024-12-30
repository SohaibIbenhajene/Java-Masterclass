public class Main {
    public static void main(String[] args) {
        int sum = 0, sumCounter = 0;
        for (int i = 1; sumCounter < 5 && i <= 1000; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                sum += i;
                sumCounter++;
                System.out.println("Found a match = " + i);
            }
        }
        System.out.println("Sum = " + sum);
    }
}