package Day_38;

import java.util.Arrays;

public class AggressiveCows {
    public static int largestMinDistance(int[] stalls, int k) {
        Arrays.sort(stalls);

        int low = 0;
        int high = stalls[stalls.length - 1] - stalls[0];
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(stalls, k, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    private static boolean isPossible(int[] stalls, int k, int minDistance) {
        int cowsPlaced = 1;
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= minDistance) {
                cowsPlaced++;
                lastPosition = stalls[i];

                if (cowsPlaced == k) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] stalls = { 1, 2, 4, 8, 9 };
        int k = 3;

        int result = largestMinDistance(stalls, k);
        System.out.println("Largest minimum distance: " + result); // Output: 3
    }
}
