package Day_22;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        // Create a frequency map for string t
        Map<Character, Integer> requiredCharCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            requiredCharCount.put(c, requiredCharCount.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int actualCharCount = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (requiredCharCount.containsKey(rightChar)) {
                requiredCharCount.put(rightChar, requiredCharCount.get(rightChar) - 1);
                if (requiredCharCount.get(rightChar) == 0) {
                    actualCharCount++;
                }
            }

            while (actualCharCount == requiredCharCount.size()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                if (requiredCharCount.containsKey(leftChar)) {
                    requiredCharCount.put(leftChar, requiredCharCount.get(leftChar) + 1);
                    if (requiredCharCount.get(leftChar) > 0) {
                        actualCharCount--;
                    }
                }

                left++;
            }

            right++;
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t)); // Output: "BANC"
    }
}
