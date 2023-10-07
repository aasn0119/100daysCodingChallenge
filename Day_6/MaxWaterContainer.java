package Day_6;

public class MaxWaterContainer {

    // Optimal implementation -> O(n)..! -> T.C
    public int maxArea(int[] height) {
        int left = 0; // Initialize the left pointer at the beginning of the array
        int right = height.length - 1; // Initialize the right pointer at the end of the array
        int maxArea = 0; // Initialize the maximum area

        while (left < right) {
            // Calculate the width between the two pointers
            int width = right - left;

            // Calculate the height of the shorter wall between the two pointers
            int minWallHeight = Math.min(height[left], height[right]);

            // Calculate the area between the two pointers
            int area = width * minWallHeight;

            // Update the maximum area if the current area is greater
            maxArea = Math.max(maxArea, area);

            // Move the pointers inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    // Brute Force Approach -> O(N^2)
    public static int maxArea_I(int[] height) {
        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int width = j - i;
                int minHeight = Math.min(height[i], height[j]);
                int area = width * minHeight;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        MaxWaterContainer solution = new MaxWaterContainer();
        int maxArea = solution.maxArea(height);
        int maxArea_I = maxArea_I(height);
        System.out.println("Maximum amount of water that can be stored: " + maxArea);
        System.out.println("Maximum amount of water that can be stored: " + maxArea_I);
    }
}
