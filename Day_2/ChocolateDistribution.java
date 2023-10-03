package Day_2;

import java.util.Arrays;

public class ChocolateDistribution {
    public static int findMinDifference(int[] chocolates, int n, int m) {
        if (m == 0 || n == 0)
            return 0;

        if (m > n)
            return -1; // Not enough chocolates to distribute to all students

        Arrays.sort(chocolates);

        int minDifference = Integer.MAX_VALUE;

        // Find the minimum difference by iterating through the sorted array
        for (int i = 0; i + m - 1 < n; i++) {
            int difference = chocolates[i + m - 1] - chocolates[i];
            if (difference < minDifference) {
                minDifference = difference;
            }
        }

        return minDifference;
    }

    public static void main(String[] args) {
        int[] chocolates = { 12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50 };
        int n = chocolates.length;
        int m = 7; // Number of students

        int minDifference = findMinDifference(chocolates, n, m);

        if (minDifference != -1) {
            System.out.println("Minimum Difference: " + minDifference);
        } else {
            System.out.println("Not enough chocolates to distribute to all students.");
        }
    }
}
