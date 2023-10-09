package Day_8;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        // Create a HashMap to store the cumulative sum and its frequency
        Map<Integer, Integer> sumFrequencyMap = new HashMap<>();
        sumFrequencyMap.put(0, 1); // Initialize with sum 0, seen once

        for (int num : nums) {
            sum += num;

            // If (sum - k) is in the map, it means there is a subarray with sum k
            if (sumFrequencyMap.containsKey(sum - k)) {
                count += sumFrequencyMap.get(sum - k);
            }

            // Increment the frequency of the current cumulative sum
            sumFrequencyMap.put(sum, sumFrequencyMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        int[] nums = { 1, 2, 3, 4, 1 };
        int k = 5;
        int totalCount = solution.subarraySum(nums, k);
        System.out.println("Total number of subarrays with sum " + k + ": " + totalCount);
    }
}
