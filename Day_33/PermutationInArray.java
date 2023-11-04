package Day_33;

// Java program to check whether 
// permutation of two arrays satisfy 
// the condition a[i] + b[i] >= k. 
import java.util.*;

public class PermutationInArray {

    // Check whether any permutation
    // exists which satisfy the condition.
    static boolean isPossible(Integer a[], int b[],
            int n, int k) {
        // Sort the array a[] in decreasing order.
        Arrays.sort(a, Collections.reverseOrder());

        // Sort the array b[] in increasing order.
        Arrays.sort(b);

        // Checking condition on each index.
        for (int i = 0; i < n; i++)
            if (a[i] + b[i] < k)
                return false;

        return true;
    }

    // Driver code
    public static void main(String[] args) {
        Integer a[] = { 2, 1, 3 };
        int b[] = { 7, 8, 9 };
        int k = 10;
        int n = a.length;

        if (isPossible(a, b, n, k))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}
