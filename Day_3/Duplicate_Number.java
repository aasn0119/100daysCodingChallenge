public class Duplicate_Number {

    // T.C -> O(n*log(n))...there is a more efficient approach but now it's the
    // best.
    public static int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;

            // Count the number of elements in the array that are less than or equal to
            // 'mid'.
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            // If there are more than 'mid' elements less than or equal to 'mid',
            // the repeated number must be in the range [left, mid].
            if (count > mid) {
                right = mid;
            } else {
                // Otherwise, the repeated number must be in the range [mid+1, right].
                left = mid + 1;
            }
        }

        // 'left' now contains the repeated number.
        return left;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 2, 2 }; // An array with a duplicate
        int duplicateNumber = findDuplicate(nums);

        if (duplicateNumber != 0) {
            System.out.println("The duplicate number is: " + duplicateNumber);
        } else {
            System.out.println("No duplicate found.");
        }
    }
}
