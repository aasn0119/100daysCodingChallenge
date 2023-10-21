
public class ReverseWords {

    public static String reverseWords(String s) {
        // Split the input string into words, removing leading and trailing spaces
        String[] words = s.trim().split("\\s+");

        // Initialize a StringBuilder to build the reversed string
        StringBuilder reversed = new StringBuilder();

        // Iterate through the words array in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]); // Append the current word
            if (i > 0) {
                reversed.append(" "); // Append a single space between words
            }
        }

        // Return the reversed string
        return reversed.toString();
    }

    public static void main(String[] args) {
        String input = "  the quick   brown   fox  ";
        String reversed = reverseWords(input);
        System.out.println("Reversed Words: " + reversed);
    }
}
