public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int nonZeroIndex = 0; // Pointer to track the position for non-zero elements

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {

                // Swap non-zero element with the element at nonZeroIndex
                int temp = nums[i];
                nums[i] = nums[nonZeroIndex];
                nums[nonZeroIndex] = temp;

                // Increment the nonZeroIndex
                nonZeroIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };
        MoveZeros solution = new MoveZeros();
        solution.moveZeroes(nums);

        // Print the modified array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
