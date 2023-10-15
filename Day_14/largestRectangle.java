package Day_14;

import java.util.Stack;

public class largestRectangle {

    // optimized solution with a T.C -> O(N) and S.C -> O(n)
    public int largestRectangleArea(int[] heights) {
        int n = heights.length; // Number of bars in the histogram
        Stack<Integer> stack = new Stack<>(); // Stack to store indices of bars
        int maxArea = 0; // Initialize the maximum area

        for (int i = 0; i < n; i++) {
            // Check if the current bar is smaller than the bar at the top of the stack
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()]; // Get the height of the bar at the top of the stack
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // Calculate the width of the rectangle

                // Update the maximum area if the current area is larger
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i); // Push the index of the current bar to the stack
        }

        // Calculate the remaining rectangles in the stack
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()]; // Get the height of the bar at the top of the stack
            int width = stack.isEmpty() ? n : n - stack.peek() - 1; // Calculate the width of the rectangle

            // Update the maximum area if the current area is larger
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea; // Return the maximum area
    }

    // brute force solution with a T.C -> O(N^3) and S.C -> O(1)
    public static int largestRectangleArea_I(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int minHeight = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    minHeight = Math.min(minHeight, heights[k]);
                }
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        largestRectangle solution = new largestRectangle();
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        int maxArea = solution.largestRectangleArea(heights);
        System.out.println("Largest Rectangle Area: " + maxArea);
        System.out.println("Largest Rectangle Area: " + largestRectangleArea_I(heights));
    }
}
