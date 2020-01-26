package methods;

public class Palindrome {

    public static boolean isPalindrome(int number) {
        int reverseNumber = 0;
        int checkNumber = number;
        boolean isNegative = false;
        if (checkNumber < 0) {
            checkNumber *= -1;
            isNegative = true;
        }
        while (checkNumber > 0) {
            reverseNumber = reverseNumber * 10 + checkNumber % 10;
            checkNumber /= 10;
        }
        if (isNegative)
            reverseNumber *= -1;
        return (reverseNumber == number);
    }
}
