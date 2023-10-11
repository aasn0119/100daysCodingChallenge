package Day_10;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // Initialize the maximum reachable index
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // If the current index is beyond the maximum reachable index, return false
            if (i > maxReach) {
                return false;
            }

            // Update the maximum reachable index if needed
            maxReach = Math.max(maxReach, i + nums[i]);

            // If the maximum reachable index is greater than or equal to the last index,
            // return true
            if (maxReach >= n - 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        int[] nums1 = { 2, 3, 1, 1, 4 };
        int[] nums2 = { 3, 2, 1, 0, 4 };
        boolean result1 = solution.canJump(nums1);
        boolean result2 = solution.canJump(nums2);
        System.out.println("Can reach the last index (nums1): " + result1);
        System.out.println("Can reach the last index (nums2): " + result2);
    }
}
