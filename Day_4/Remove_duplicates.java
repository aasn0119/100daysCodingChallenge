package Day_4;

public class Remove_duplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int k = 1; // Initialize the unique element count (k) to 1 (since the first element is
                   // always unique)
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i]; // Move the unique element to position k
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 2, 3, 4, 4, 5 };
        Remove_duplicates solution = new Remove_duplicates();
        int uniqueCount = solution.removeDuplicates(nums);

        System.out.println("Number of unique elements: " + uniqueCount);

        // Print the array with unique elements
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
