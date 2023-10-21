import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramGroups {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // Create a hashmap to group anagrams
        Map<String, List<String>> anagramGroups = new HashMap<>();

        // Iterate through the input strings
        for (String str : strs) {
            // Convert the string to a character array and sort it
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // Check if the sorted representation is in the hashmap
            if (!anagramGroups.containsKey(sortedStr)) {
                // If not, create a new entry for it
                anagramGroups.put(sortedStr, new ArrayList<>());
            }

            // Add the original string to the corresponding group
            anagramGroups.get(sortedStr).add(str);
        }

        // Convert the values of the hashmap to a list and return it
        return new ArrayList<>(anagramGroups.values());
    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> anagramGroups = groupAnagrams(strs);

        // Print the grouped anagrams
        for (List<String> group : anagramGroups) {
            System.out.println(group);
        }
    }
}
