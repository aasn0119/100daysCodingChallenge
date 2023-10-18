package Day_16;

public class ValidPalindromeII {

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // If the characters at the current positions don't match, try two options:
                // 1. Skip the character at the left position.
                // 2. Skip the character at the right position.
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }

            // Move the pointers towards the center.
            left++;
            right--;
        }

        // If we reach this point, the string is already a palindrome or can be made one
        // by deleting at most one character.
        return true;
    }

    // Helper function to check if a substring of s is a palindrome.
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abca";
        System.out.println("Is the given String Pallindrome even after deleting 1 character? " + validPalindrome(str));
    }
}
