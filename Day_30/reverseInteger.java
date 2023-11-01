package Day_30;

public class reverseInteger {
    public static int reverse(int x) {
        int reversed = 0; // Initialize the variable to store the reversed integer.

        while (x != 0) {
            int pop = x % 10; // Extract the last digit of the input integer (x).

            // Check for integer overflow in both positive and negative cases.
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0; // Overflow case, return 0.
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0; // Overflow case for negative integers, return 0.
            }

            reversed = reversed * 10 + pop; // Update the reversed integer by shifting digits and adding the last digit.
            x /= 10; // Remove the last digit from the input integer.
        }

        return reversed; // Return the reversed integer.
    }

    public static void main(String[] args) {
        int num = 12345; // Replace with the integer you want to reverse.
        int reversedNum = reverse(num);
        System.out.println("Original Number: " + num);
        System.out.println("Reversed Number: " + reversedNum);
    }

}
