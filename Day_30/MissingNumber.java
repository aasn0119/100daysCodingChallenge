package Day_30;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = { 3, 0, 1 };
        int missingNumber = findMissingNumber(nums);
        System.out.println("The missing number is: " + missingNumber);
    }

    public static int findMissingNumber(int[] nums) {
        int n = nums.length;
        // Calculate the expected sum of numbers from 0 to n
        int expectedSum = (n * (n + 1)) / 2;

        // Calculate the actual sum of elements in the array
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        // The missing number is the difference between the expected and actual sums
        return expectedSum - actualSum;
    }
}
