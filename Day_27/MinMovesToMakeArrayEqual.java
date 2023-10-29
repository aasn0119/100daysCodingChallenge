package Day_27;

public class MinMovesToMakeArrayEqual {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int moves = minMoves(nums);
        System.out.println("Minimum moves to make all elements equal: " + moves);
    }

    public static int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE; // Initialize min to a maximum value.
        int sum = 0;

        // Find the minimum element and calculate the sum of all elements.
        for (int num : nums) {
            min = Math.min(min, num); // Update min if a smaller element is found.
            sum += num;
        }

        // Calculate the minimum number of moves to make all elements equal.
        return sum - min * nums.length;
    }
}
