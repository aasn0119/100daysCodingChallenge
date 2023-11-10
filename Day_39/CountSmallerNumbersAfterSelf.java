package Day_39;

import java.util.*;

public class CountSmallerNumbersAfterSelf {
    public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] indexes = new int[n];
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        mergeSort(nums, indexes, temp, result, 0, n - 1);

        return Arrays.asList(Arrays.stream(result).boxed().toArray(Integer[]::new));
    }

    private static void mergeSort(int[] nums, int[] indexes, int[] temp, int[] result, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(nums, indexes, temp, result, start, mid);
            mergeSort(nums, indexes, temp, result, mid + 1, end);
            merge(nums, indexes, temp, result, start, mid, end);
        }
    }

    private static void merge(int[] nums, int[] indexes, int[] temp, int[] result, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = start;
        int rightCount = 0;

        while (i <= mid && j <= end) {
            if (nums[indexes[i]] > nums[indexes[j]]) {
                temp[k] = indexes[j];
                j++;
                rightCount++;
            } else {
                temp[k] = indexes[i];
                result[indexes[i]] += rightCount;
                i++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = indexes[i];
            result[indexes[i]] += rightCount;
            i++;
            k++;
        }

        while (j <= end) {
            temp[k] = indexes[j];
            j++;
            k++;
        }

        System.arraycopy(temp, start, indexes, start, end - start + 1);
    }

    public static void main(String[] args) {
        int[] nums = { 5, 2, 6, 1 };
        List<Integer> result = countSmaller(nums);
        System.out.println("Counts of smaller numbers to the right: " + result);
    }
}
