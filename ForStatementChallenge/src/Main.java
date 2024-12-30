public class Main {
    public static void main(String[] args) {
        System.out.println("0 is " + (isPrime(0) ? "" : "NOT " ) + "a prime number");
        System.out.println("1 is " + (isPrime(1) ? "" : "NOT " ) + "a prime number");
        System.out.println("2 is " + (isPrime(2) ? "" : "NOT " ) + "a prime number");
        System.out.println("3 is " + (isPrime(3) ? "" : "NOT " ) + "a prime number");

        int primeCounter = 0;

        for (int i = 3; i <= 1000; i += 34) {
            if (isPrime(i)) {
                primeCounter++;
                System.out.println(i + " is a prime number");
                if (primeCounter == 3) break;
            }
        }
    }

    public static boolean isPrime(int wholeNumber) {
        if (wholeNumber <= 1) return false;

        for (int divisor = 2; divisor < wholeNumber; divisor++) {
            if (wholeNumber % divisor == 0) {
                return false;
            }
        }

        return true;
    }
}