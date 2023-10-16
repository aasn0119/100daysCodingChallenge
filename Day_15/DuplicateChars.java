package Day_15;

import java.util.*;

public class DuplicateChars {

    // Optimized Solution uses O(n) time and O(n) Space as well...!
    public static void countDuplicates(String str) {

        // declaring a Map to store characters and their corrosponding frequencies...!
        Map<Character, Integer> charCount = new HashMap<>();

        // counting the frequency of each character..!
        for (char c : str.toLowerCase().toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // printing characters with frequency greater than 1...!
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " occurs " + entry.getValue() + " times.");
            }
        }
    }

    // Brute force Solution uses O(n*log(N)) time and O(1) Space as well...!
    public static void countDuplicates_I(String str) {
        int len = str.length();

        // Sorting the String...!
        char ch[] = str.toLowerCase().toCharArray();
        Arrays.sort(ch);
        String sortedStr = new String(ch);

        // looping through the String and finding the duplicates...!
        for (int i = 0; i < len; i++) {
            int cnt = 1;

            // counting the times each character appears in the String...!
            while (i < len - 1 && sortedStr.charAt(i) == sortedStr.charAt(i + 1)) {
                cnt++;
                i++;
            }

            // printing the duplicates and their counts..!
            if (cnt > 1) {
                System.out.println(sortedStr.charAt(i) + ", Count: " + cnt);
            }
        }
    }

    public static void main(String[] args) {
        String str = "Geeksforgeeks";
        System.out.println("Duplicate characters and their frequencies: ");
        countDuplicates(str);
        countDuplicates_I(str);
    }
}