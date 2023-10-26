package Day_24;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // Create a 2D array to store the number of distinct subsequences
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the base case
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1; // Any string has one empty subsequence
        }

        // Fill in the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // If the current characters match, we have two choices:
                    // 1. Use the current character in both strings, so dp[i-1][j-1] ways.
                    // 2. Skip the current character in string s, so dp[i-1][j] ways.
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // If the current characters don't match, we can only skip the character in
                    // string s.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        DistinctSubsequences solution = new DistinctSubsequences();
        String s = "rabbbit";
        String t = "rabbit";
        int result = solution.numDistinct(s, t);
        System.out.println("Number of distinct subsequences: " + result);
    }
}
