package Day_16;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        // Check for edge cases
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Initialize the prefix with the first string
        String prefix = strs[0];

        // Iterate through the array of strings starting from the second string
        for (int i = 1; i < strs.length; i++) {
            // Compare the current string with the current prefix
            while (strs[i].indexOf(prefix) != 0) {
                // If the prefix is not a prefix of the current string, remove the last
                // character
                prefix = prefix.substring(0, prefix.length() - 1);

                // If the prefix becomes empty, there is no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        // Return the longest common prefix found
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        System.out.println("Longest Common Prefix is: " + longestCommonPrefix(strs));
    }
}