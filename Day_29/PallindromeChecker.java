public class PallindromeChecker {
    public static void main(String[] args) {
        int x = 121;
        boolean isPalindrome = isPalindrome(x);
        System.out.println("Is " + x + " a palindrome? " + isPalindrome);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false; // Negative numbers can't be palindromes
        }

        // Convert the integer to a string
        String original = Integer.toString(x);

        // Create a StringBuilder to reverse the string
        StringBuilder reversed = new StringBuilder(original).reverse();

        // Check if the original string is equal to the reversed string
        return original.equals(reversed.toString());
    }
}
