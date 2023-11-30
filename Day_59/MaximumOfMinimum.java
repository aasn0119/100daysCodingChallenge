package Day_59;

import java.util.*;

class MaximumOfMinimum {
    public int[] maxOfMin(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        // For each element, store the index of the next smaller element on the left
        int[] left = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Clear the stack for the next iteration
        stack.clear();

        // For each element, store the index of the next smaller element on the right
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate the maximum of the minimums for each window
        for (int i = 0; i < n; i++) {
            int windowSize = right[i] - left[i] - 1;
            result[windowSize - 1] = Math.max(result[windowSize - 1], arr[i]);
        }

        // Fill in any remaining values in the result array
        for (int i = n - 2; i >= 0; i--) {
            result[i] = Math.max(result[i], result[i + 1]);
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumOfMinimum solution = new MaximumOfMinimum();
        int[] arr = { 10, 20, 30, 50, 10, 70, 30 };
        int[] result = solution.maxOfMin(arr);
        System.out.println(Arrays.toString(result));
    }
}
