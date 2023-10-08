package Day_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, long target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        int count = 0;
        for (int num : nums) {
            if (num >= 0) {
                continue;
            } else {
                count++;
            }
        }

        if (target < 0 && count == 0) {
            return new ArrayList<>(result);
        }

        for (int a = 0; a < nums.length - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue; // Skip duplicates for the first element
            }

            for (int b = a + 1; b < nums.length - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue; // Skip duplicates for the second element
                }

                int left = b + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = nums[a] + nums[b] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[a], nums[b], nums[left], nums[right]));

                        left++;
                        right--;

                        // Adjust left and right pointers to skip duplicates
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 0, -1, 0, -2, 2 };
        int target1 = 0;
        FourSum solution = new FourSum();
        List<List<Integer>> quadruplets1 = solution.fourSum(nums1, target1);
        System.out.println("Unique quadruplets that sum to the target: " + quadruplets1);

        int[] nums2 = { 2, 2, 2, 2, 2 };
        int target2 = 8;
        List<List<Integer>> quadruplets2 = solution.fourSum(nums2, target2);
        System.out.println("Unique quadruplets that sum to the target: " + quadruplets2);

        int[] nums3 = { 1000000000, 1000000000, 1000000000, 1000000000 };
        int target3 = -294967296;
        List<List<Integer>> quadruplets3 = solution.fourSum(nums3, target3);
        System.out.println("Unique quadruplets that sum to the target: " + quadruplets3);
    }
}
