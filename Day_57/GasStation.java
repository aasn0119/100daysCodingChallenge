package Day_57;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int start = 0;
        int tank = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];

            // If the truck cannot reach the next petrol pump
            if (tank < 0) {
                // Reset starting point and tank
                start = i + 1;
                tank = 0;
            }
        }

        // If the total gas is greater than or equal to the total cost, a solution
        // exists
        return totalGas >= totalCost ? start : -1;
    }

    public static void main(String[] args) {
        int[] gas = { 1, 2, 3, 4, 5 };
        int[] cost = { 3, 4, 5, 1, 2 };
        int result = canCompleteCircuit(gas, cost);
        System.out.println("Starting point: " + result);
    }
}
