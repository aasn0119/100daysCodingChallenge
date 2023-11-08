package Day_37;

public class PeakElement {
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Compare the middle element with its right neighbor
            if (nums[mid] > nums[mid + 1]) {
                right = mid; // The peak is to the left
            } else {
                left = mid + 1; // The peak is to the right
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        int peakIndex = findPeakElement(nums);
        System.out.println("Peak element is at index: " + peakIndex);
    }
}
