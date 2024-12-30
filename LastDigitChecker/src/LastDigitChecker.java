public class LastDigitChecker {
    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(9, 99, 19));
    }

    // write code here
    public static boolean hasSameLastDigit(int numOne, int numTwo, int numThree) {
        if (!isValid(numOne) || !isValid(numTwo) || !isValid(numThree)) { return false; }

        int lastDigitOne = numOne % 10, lastDigitTwo = numTwo % 10, lastDigitThree = numThree % 10;
        if (lastDigitOne == lastDigitTwo || lastDigitTwo == lastDigitThree || lastDigitOne == lastDigitThree) {
            return true;
        }
        return false;
    }

    public static boolean isValid(int number) {
        if (number >= 10 || number <= 1000) {
            return true;
        }
        return false;
    }
}