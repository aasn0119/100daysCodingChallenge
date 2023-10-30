package Day_28;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int maxProduct = maximumProduct(nums);
        System.out.println("Maximum product of three numbers: " + maxProduct);
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // Maximum product can be one of these two possibilities:
        // 1. Product of the three largest positive numbers
        // 2. Product of the two smallest (negative) numbers and the largest positive
        // number
        int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int option2 = nums[0] * nums[1] * nums[n - 1];
        return Math.max(option1, option2);
    }
}
