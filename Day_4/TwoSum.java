package Day_4;

// This problem can basically have two solution depending upon situation these can be used..!
// One have T.C -> O(n^2) and S.C -> O(1) ( kind of Brute force)
// The other have T.C -> O(n) and S.C -> O(n) (efficient solution)

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // Efficient Approach...!
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numIndexMap.containsKey(complement)) {
                // Found a pair that adds up to the target
                return new int[] { numIndexMap.get(complement), i };
            }

            // Store the current number and its index in the map
            numIndexMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two elements add up to the target.");
    }

    // Brute force Approach...!
    public int[] twoSum_I(int[] nums, int target) {
        int n = nums.length;
        int ans[] = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        TwoSum solution = new TwoSum();
        int[] result = solution.twoSum(nums, target);
        int[] result_I = solution.twoSum_I(nums, target);

        System.out.println("Indices of two numbers that add up to target: " + result[0] + ", " + result[1]);
        System.out.println("Indices of two numbers that add up to target: " + result_I[0] + ", " + result_I[1]);
    }
}
