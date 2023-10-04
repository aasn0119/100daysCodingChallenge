import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {
        int low = 0; // Pointer for 0s
        int mid = 0; // Pointer for 1s
        int high = nums.length - 1; // Pointer for 2s

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap nums[low] and nums[mid]
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // 1s are in their correct position, just move mid pointer.
                mid++;
            } else { // nums[mid] == 2
                // Swap nums[mid] and nums[high]
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 0 };
        sortColors(nums);
        System.out.println("Sorted Colors: " + Arrays.toString(nums)); // Output: [0, 1, 2]
    }
}
