package Day_27;

public class AddBinaryStrings {
    public static void main(String[] args) {
        String a = "1101";
        String b = "101";
        String sum = addBinary(a, b);
        System.out.println("Sum of binary strings: " + sum);
    }

    public static String addBinary(String a, String b) {
        // Initialize a StringBuilder to store the result.
        StringBuilder result = new StringBuilder();
        // Initialize the carry to 0.
        int carry = 0;

        int i = a.length() - 1;
        int j = b.length() - 1;

        // Iterate through the input strings from right to left.
        while (i >= 0 || j >= 0 || carry > 0) {
            // Get the current digits of both strings (0 or 1).
            int digitA = (i >= 0) ? a.charAt(i) - '0' : 0;
            int digitB = (j >= 0) ? b.charAt(j) - '0' : 0;

            // Calculate the sum of digits along with the carry.
            int sum = digitA + digitB + carry;

            // Insert the result digit (0 or 1) at the beginning of the result string.
            result.insert(0, sum % 2);

            // Update the carry for the next iteration.
            carry = sum / 2;

            i--;
            j--;
        }

        // Convert the StringBuilder to a string and return the result.
        return result.toString();
    }
}
