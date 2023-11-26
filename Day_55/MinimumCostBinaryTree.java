package Day_55;

import java.util.Arrays;

public class MinimumCostBinaryTree {
    public static int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (len == 1) {
                    dp[i][j] = 0;
                } else {
                    for (int k = i; k < j; k++) {
                        int leftMax = findMax(arr, i, k);
                        int rightMax = findMax(arr, k + 1, j);
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + leftMax * rightMax);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    private static int findMax(int[] arr, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 2, 4 };
        int result = mctFromLeafValues(arr);
        System.out.println("Minimum cost of the binary tree: " + result);
    }
}
