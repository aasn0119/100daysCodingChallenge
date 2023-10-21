import java.util.ArrayList;
import java.util.List;

public class RabinKarpAlgorithm {
    private static final int PRIME = 101;

    // Function to search for all occurrences of a pattern in a text
    public static List<Integer> search(char[] P, char[] T) {
        List<Integer> occurrences = new ArrayList<>();
        int n = T.length;
        int m = P.length;

        int patternHash = createHash(P, m); // Calculate hash for the pattern
        int textHash = createHash(T, m); // Calculate hash for the initial window of text

        for (int i = 0; i <= n - m; i++) {
            // Compare hashes and characters
            if (patternHash == textHash && checkEqual(P, T, i, i + m - 1)) {
                occurrences.add(i); // Add the position to the list of occurrences
            }

            if (i < n - m) {
                textHash = recalculateHash(T, textHash, m, i); // Recalculate hash for the next window
            }
        }

        return occurrences;
    }

    // Function to create a hash value for a string of a given length
    private static int createHash(char[] str, int len) {
        int hash = 0;
        for (int i = 0; i < len; i++) {
            hash = (hash * PRIME + str[i]) % Integer.MAX_VALUE;
        }
        return hash;
    }

    // Function to recalculate the hash value for a new window
    private static int recalculateHash(char[] str, int oldHash, int len, int startIndex) {
        int newHash = (oldHash - str[startIndex] * (int) Math.pow(PRIME, len - 1)) * PRIME + str[startIndex + len];
        return newHash % Integer.MAX_VALUE;
    }

    // Function to check if characters in two strings match
    private static boolean checkEqual(char[] P, char[] T, int start, int end) {
        for (int i = 0; i < P.length; i++) {
            if (P[i] != T[start + i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[] T = "AABAACAADAABAABA".toCharArray();
        char[] P = "AABA".toCharArray();

        List<Integer> occurrences = search(P, T);
        if (occurrences.isEmpty()) {
            System.out.println("Pattern not found in text.");
        } else {
            System.out.println("Pattern found at positions: " + occurrences);
        }
    }
}
