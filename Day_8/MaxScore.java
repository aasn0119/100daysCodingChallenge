package Day_8;

public class MaxScore {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0; // Step 1: Calculate the total sum of all card points
        int minSubarray = 0; // Initialize variables for the sliding window

        for (int i = 0, currSum = 0; i < n; i++) {
            totalSum += cardPoints[i]; // Accumulate the total sum
            currSum += cardPoints[i]; // Accumulate the current sum

            if (i < n - k) {
                minSubarray += cardPoints[i];
            } else {
                currSum -= cardPoints[i - (n - k)]; // Adjust current sum
                minSubarray = Math.min(minSubarray, currSum);
            }
        }

        return totalSum - minSubarray; // Calculate the maximum score
    }

    public static void main(String[] args) {
        MaxScore solution = new MaxScore();
        int[] cardPoints = { 1, 2, 3, 4, 5, 6, 1 };
        int k = 3;
        int maxScore = solution.maxScore(cardPoints, k);
        System.out.println("Maximum score: " + maxScore);
    }
}
