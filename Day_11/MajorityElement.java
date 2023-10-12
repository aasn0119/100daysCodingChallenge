package Day_11;

public class MajorityElement {
    public static Integer findMajorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        // Verify if the candidate is a majority element
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return candidate;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2, 1, 1, 1, 2, 2 };
        Integer result = findMajorityElement(arr);

        if (result != null) {
            System.out.println("The majority element is " + result);
        } else {
            System.out.println("There is no majority element in the array.");
        }
    }
}
