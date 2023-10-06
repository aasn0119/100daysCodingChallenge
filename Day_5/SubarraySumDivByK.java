package Day_5;

public class SubarraySumDivByK {

    // Optimal Approach -> O(n) -> T.C and O(n) -> S.C
    public int subarraysDivByK(int[] nums, int k) {
        int[] modCount = new int[k];
        int sum = 0;
        int count = 0;

        modCount[0] = 1;

        for (int num : nums) {
            sum += num;
            int remainder = (sum % k + k) % k; // Ensure that remainder is non-negative
            count += modCount[remainder];
            modCount[remainder]++;
        }

        return count;
    }

    public static int subarraysDivisibleByK(int[] nums, int k) {
        int count = 0;

        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 0, -2, -3, 1 };
        int k = 5;
        SubarraySumDivByK solution = new SubarraySumDivByK();
        int count = solution.subarraysDivByK(nums, k);
        int ans = subarraysDivisibleByK(nums, k);
        System.out.println("Number of subarrays with sum divisible by k: " + count);
        System.out.println("Number of subarrays with sum divisible by k: " + ans);

    }
}
