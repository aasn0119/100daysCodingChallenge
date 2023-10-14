package Day_13;

import java.util.*;

public class MaxValueOfEquation {

    public static int findMaxValueOfEquation(int[][] arr, int k) {
        int maxvalue = Integer.MIN_VALUE;

        // Iterate over all the pairs...!
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                // calculate the equation value...!
                int equationValue = arr[i][1] + arr[j][1] + Math.abs(arr[i][0] - arr[j][0]);

                // check if |xi - xj| <= k...!!!
                if (Math.abs(arr[i][0] - arr[j][0]) <= k) {
                    // update Maxvalur if current value is greater..!
                    maxvalue = Math.max(maxvalue, equationValue);
                }
            }
        }
        return maxvalue;
    }

    /*
     * An optimal solution with O(n) T.C
     * public int findMaxValueOfEquation_I(int[][] points, int k) {
     * PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
     * (a, b) -> (a.getKey() == b.getKey() ? a.getValue() - b.getValue() :
     * b.getKey() - a.getKey()));
     * int res = Integer.MIN_VALUE;
     * for (int[] point : points) {
     * while (!pq.isEmpty() && point[0] - pq.peek().getValue() > k) {
     * pq.poll();
     * }
     * if (!pq.isEmpty()) {
     * res = Math.max(res, pq.peek().getKey() + point[0] + point[1]);
     * }
     * pq.offer(new Pair<>(point[1] - point[0], point[0]));
     * }
     * return res;
     * }
     */
    public static void main(String[] args) {
        int[][] points = { { 1, 3 }, { 2, 0 }, { 3, 10 }, { 4, 5 }, { 5, 5 } };
        int k = 2;

        // Find and print the maximum value of the equation
        int result = findMaxValueOfEquation(points, k);
        System.out.println("Maximum Value of Equation: " + result);
    }
}