public class WordWrap {

    public static int solveWordWrap(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] breaks = new int[n];

        int[][] extraSpaces = new int[n][n];
        for (int i = 0; i < n; i++) {
            extraSpaces[i][i] = k - nums[i];
            for (int j = i + 1; j < n; j++) {
                extraSpaces[i][j] = extraSpaces[i][j - 1] - nums[j] - 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (extraSpaces[i][j] < 0) {
                    extraSpaces[i][j] = Integer.MAX_VALUE;
                } else if (j == n - 1) {
                    extraSpaces[i][j] = 0;
                } else {
                    extraSpaces[i][j] = extraSpaces[i][j] * extraSpaces[i][j];
                }
            }
        }

        dp[0] = extraSpaces[0][0];
        for (int j = 1; j < n; j++) {
            dp[j] = extraSpaces[0][j];
            breaks[j] = 0;
            for (int i = 1; i <= j; i++) {
                if (dp[i - 1] != Integer.MAX_VALUE && extraSpaces[i][j] != Integer.MAX_VALUE &&
                    (dp[i - 1] + extraSpaces[i][j] < dp[j])) {
                    dp[j] = dp[i - 1] + extraSpaces[i][j];
                    breaks[j] = i;
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] wordLengths = {3, 2, 2, 5};
        int maxWidth = 6;

        int minCost = solveWordWrap(wordLengths, maxWidth);
        System.out.println("Minimum cost for word wrap: " + minCost);
    }
}
