package Day_6;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] < 0) {
                // If the number is already negative, it means it has been seen before
                duplicates.add(num);
            } else {
                // Mark the number as seen by making the corresponding element negative
                nums[num - 1] = -nums[num - 1];
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 1, 5 };
        FindDuplicates solution = new FindDuplicates();
        List<Integer> duplicates = solution.findDuplicates(nums);

        System.out.println("Duplicate numbers: " + duplicates);
    }
}
