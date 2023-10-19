package Day_18;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindow {

    public static String findSmallestWindow(String s, String p) {
        Map<Character, Integer> charCountP = new HashMap<>();
        Map<Character, Integer> charCountS = new HashMap<>();

        // Populate charCountP with the character counts in string P
        for (char c : p.toCharArray()) {
            charCountP.put(c, charCountP.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int minWindow = Integer.MAX_VALUE;
        int minWindowStart = 0;
        int count = charCountP.size();

        for (int right = 0; right < s.length(); right++) {
            char charRight = s.charAt(right);

            if (charCountP.containsKey(charRight)) {
                charCountS.put(charRight, charCountS.getOrDefault(charRight, 0) + 1);

                if (charCountS.get(charRight).intValue() == charCountP.get(charRight).intValue()) {
                    count--;
                }
            }

            while (count == 0) {
                if (right - left + 1 < minWindow) {
                    minWindow = right - left + 1;
                    minWindowStart = left;
                }

                char charLeft = s.charAt(left);

                if (charCountP.containsKey(charLeft)) {
                    charCountS.put(charLeft, charCountS.get(charLeft) - 1);

                    if (charCountS.get(charLeft).intValue() < charCountP.get(charLeft).intValue()) {
                        count++;
                    }
                }

                left++;
            }
        }

        return minWindow == Integer.MAX_VALUE ? "-1" : s.substring(minWindowStart, minWindowStart + minWindow);
    }

    public static void main(String[] args) {
        String s = "timetopractice";
        String p = "toc";

        String smallestWindow = findSmallestWindow(s, p);
        System.out.println("Smallest Window: " + smallestWindow);
    }
}
