package Day_32;

import java.util.ArrayList;
import java.util.Collections;

public class KthFactorOfN {
    public static int kthFactor(int n, int k) {
        // Create an ArrayList to store the factors
        ArrayList<Integer> factors = new ArrayList<>();

        // Iterate through numbers from 1 to the square root of n
        for (int i = 1; i * i <= n; i++) {
            // Check if n is divisible by i
            if (n % i == 0) {
                // Add both i and n / i as factors
                factors.add(i);
                // Avoid duplicates for perfect squares
                if (i != n / i) {
                    factors.add(n / i);
                }
            }
        }

        // Sort the factors in ascending order
        Collections.sort(factors);

        // Check if k is within bounds
        if (k <= factors.size()) {
            return factors.get(k - 1);
        } else {
            // k is larger than the number of factors
            return -1;
        }
    }

    public static void main(String[] args) {
        int n = 12;
        int k = 3;

        int result = kthFactor(n, k);

        if (result != -1) {
            System.out.println("The " + k + "th factor of " + n + " is: " + result);
        } else {
            System.out.println("There are fewer than " + k + " factors for " + n);
        }
    }
}
