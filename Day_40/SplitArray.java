package Day_40;

public class SplitArray {

    private int[] nums;

    public SplitArray(int[] nums) {
        this.nums = nums;
    }

    public int splitArray(int m) {
        int low = 0, high = 0, min = Integer.MAX_VALUE;

        // Finding the range for binary search
        for (int i = 0; i < nums.length; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        // Binary search
        while (low <= high) {
            int mid = (low + high) / 2;

            // Checking if the current mid value satisfies the condition
            if (requiredNoOfChunks(mid, m)) {
                min = Math.min(min, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return min;
    }

    // Helper function to check if the given mid value satisfies the condition
    private boolean requiredNoOfChunks(int mid, int m) {
        int chunks = 0, i = 0;

        // Iterating through nums to count the number of chunks
        while (i < nums.length) {
            int val = 0;

            // Adding elements to the current chunk until the sum exceeds mid
            while (i < nums.length && nums[i] + val <= mid) {
                val += nums[i++];
            }

            chunks++;
        }

        // Checking if the number of chunks is less than or equal to m
        return chunks <= m;
    }

    public static void main(String[] args) {
        // Example usage
        int[] nums = { 7, 2, 5, 10, 8 };
        int m = 2;

        SplitArray splitArray = new SplitArray(nums);
        int result = splitArray.splitArray(m);

        System.out.println("Minimum Largest Sum of Split Subarrays: " + result);
    }
}
