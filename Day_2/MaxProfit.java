package Day_2;

public class MaxProfit {
    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE; // Initialize the minimum price to a very large value
        int maxProfit = 0; // Initialize the maximum profit to 0

        // Iterate through the prices array
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                // If the current price is lower than the minimum price seen so far, update the
                // minimum price
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                // If the current price minus the minimum price is greater than the maximum
                // profit seen so far, update the maximum profit
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        MaxProfit solution = new MaxProfit();
        int maxProfit = solution.maxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}
