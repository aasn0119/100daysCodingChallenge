package Day_5;

public class MaxProfit_II {
    public int maxProfit(int[] prices) {
        int maxProfit = 0; // Initialize the maximum profit to 0

        // Iterate through the prices array, starting from the second day (index 1)
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1]; // Calculate the profit for the current day

            if (profit > 0) { // If the profit is positive, it's a potential profit
                maxProfit += profit; // Accumulate the potential profit to the maximum profit
            }

        }

        return maxProfit; // Return the maximum profit achievable
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 }; // Example prices array
        MaxProfit_II solution = new MaxProfit_II();
        int maxProfit = solution.maxProfit(prices); // Calculate the maximum profit

        System.out.println("Maximum Profit: " + maxProfit); // Print the maximum profit
    }
}
