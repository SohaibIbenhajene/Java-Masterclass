public class LargestPrimeFactor {
    public static void main(String[] args) {
        System.out.println(getLargestPrime(49));
    }

    public static int getLargestPrime(int number) {
        if (number < 2) { return -1; }

        int largestPrime = 2, i = 1;
        while (number != 1) {
            i++;
            for (int j = 1; j <= i / 2; j++) {
                if (number % i == 0) {
                    number /= i;
                    largestPrime = i;
                    i = 1;
                    break;
                }
            }
        }
        return largestPrime;
    }
}
