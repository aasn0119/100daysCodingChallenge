package Day_34;

import java.util.*;

public class DifferenceOfPairs {
    public static boolean differenceOfPairs(int[] arr, int k) {
        int size = arr.length;

        // Step-1 Sort the array
        Arrays.sort(arr);

        // Initialize positions of two elements
        int l = 0;
        int r = 1;

        // take absolute value of difference
        // this does not affect the pair as A-B=diff is same as
        // B-A= -diff
        k = Math.abs(k);

        // Search for a pair

        // These loop running conditions are sufficient
        while (l <= r && r < size) {
            int diff = arr[r] - arr[l];
            if (diff == k
                    && l != r) // we need distinct elements in pair
                               // so l!=r
            {
                System.out.print("Pair Found: (" + arr[l] + ", "
                        + arr[r] + ")");
                return true;
            } else if (diff > k) // try to reduce the diff
                l++;
            else // Note if l==r then r will be advanced thus no
                 // pair will be missed
                r++;
        }
        System.out.print("No such pair");
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 8, 30, 40, 100 };
        int diff = -60;
        differenceOfPairs(arr, diff);
    }
}