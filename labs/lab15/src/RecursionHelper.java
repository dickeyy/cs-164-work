public class RecursionHelper {

    /**
     * Reverses a given string using recursion.
     *
     * Base Case: If the input string is empty or has only one character, return the string itself.
     * Recursive Case: Concatenate the last character with the reversed substring of the string excluding the last character.
     *
     * @param str The input string to be reversed.
     * @return The reversed string.
     */
    public String reverseString(String str) {
        // Base Case
        if (str.length() <= 1) {
            return str;
        }

        // Recursive Case
        char lastChar = str.charAt(str.length() - 1);
        String reversedSubstring = reverseString(str.substring(0, str.length() - 1));
        return lastChar + reversedSubstring;
    }

    /**
     * Calculates the sum of cubes of digits for a given number using recursion.
     *
     * Base Case: If the given number is a single-digit number, return the cube of that digit.
     * Recursive Case: Calculate the cube of the last digit and add it to the sum of cubes of the remaining digits.
     *
     * @param num   The number for which the sum of cubes of digits is calculated.
     * @param total The running total (initialize with 0 in the first call).
     * @return The sum of cubes of digits.
     */
    public int armstrongNumber(int num, int total) {
        // Base Case
        if (num < 10) {
            return total + (int) Math.pow(num, 3);
        }

        // Recursive Case
        int lastDigit = num % 10;
        int remainingDigits = num / 10;
        return armstrongNumber(remainingDigits, total + (int) Math.pow(lastDigit, 3));
    }

    /**
     * Checks if a given string is a palindrome using recursion.
     *
     * Base Case: If the input string is empty or has only one character, return true.
     * Recursive Case: Check if the first and last characters are the same, and recur for the substring excluding these characters.
     *
     * @param str The input string to be checked for palindrome.
     * @return True if the string is a palindrome, false otherwise.
     */
    public boolean palindromeChecker(String str) {
        // Base Case
        if (str.length() <= 1) {
            return true;
        }

        // Recursive Case
        char firstChar = str.charAt(0);
        char lastChar = str.charAt(str.length() - 1);
        String remainingSubstring = str.substring(1, str.length() - 1);
        return (firstChar == lastChar) && palindromeChecker(remainingSubstring);
    }
}
