package Day_11;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSortAndCount(nums, 0, nums.length - 1);
    }

    private int mergeSortAndCount(int[] nums, int left, int right) {
        if (left >= right) {
            return 0; // No reverse pairs in a single element or empty array.
        }

        int mid = left + (right - left) / 2;
        int count = mergeSortAndCount(nums, left, mid) + mergeSortAndCount(nums, mid + 1, right);
        count += merge(nums, left, mid, right);
        return count;
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1)); // Count the number of pairs that meet the condition.
        }

        int[] merged = new int[right - left + 1];
        int p = 0, p1 = left, p2 = mid + 1;

        while (p1 <= mid || p2 <= right) {
            if (p1 > mid) {
                merged[p++] = nums[p2++];
            } else if (p2 > right) {
                merged[p++] = nums[p1++];
            } else {
                if (nums[p1] < nums[p2]) {
                    merged[p++] = nums[p1++];
                } else {
                    merged[p++] = nums[p2++];
                }
            }
        }

        System.arraycopy(merged, 0, nums, left, merged.length); // Copy the merged subarray back to the original array.
        return count; // Return the count of reverse pairs found in this merge.
    }

    public static void main(String[] args) {
        ReversePairs solution = new ReversePairs();
        int[] nums = { 1, 3, 2, 3, 1 };
        int count = solution.reversePairs(nums);
        System.out.println("Number of reverse pairs: " + count);
    }
}
