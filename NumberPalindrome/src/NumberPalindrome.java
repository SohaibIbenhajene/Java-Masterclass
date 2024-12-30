public class NumberPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-222));
    }

    // write code here
    public static boolean isPalindrome(int number) {
        if (number == 0) { return false; }

        int reverse = 0, originalNumber = number;
        while (number != 0) {
            reverse = (reverse * 10) + (number % 10);
            number /= 10;
        }

        return (originalNumber == reverse);
    }
}