package Day_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Sort the input array in ascending order
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1;
                int right = nums.length - 1;
                int target = -nums[i];

                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        // Found a valid triplet
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        // Skip duplicates of the second number
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        
                        // Skip duplicates of the third number
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        // Move the pointers inward
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum solution = new ThreeSum();
        List<List<Integer>> triplets = solution.threeSum(nums);
        System.out.println("Unique triplets that sum to zero: " + triplets);
    }
}

