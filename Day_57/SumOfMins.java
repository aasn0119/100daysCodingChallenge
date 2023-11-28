package Day_57;

import java.util.Stack;

public class SumOfMins {
    public static int sumOfMins(int[] arr) {
        final int MOD = 1_000_000_007;
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Calculate the left boundary of each element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Calculate the right boundary of each element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long result = 0;

        // Calculate the contribution of each element to the sum of minimums
        for (int i = 0; i < n; i++) {
            result = (result + (long) arr[i] * (i - left[i]) * (right[i] - i)) % MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };
        System.out.println(sumOfMins(arr));
    }
}
