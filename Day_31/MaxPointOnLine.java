import java.util.*;

public class MaxPointOnLine {
    public int maxPoints(int[][] points) {
        if (points.length < 2) {
            return points.length;
        }

        int maxPoints = 2; // At least 2 points are needed for a line.

        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> slopeCount = new HashMap<>();
            int duplicatePoints = 0;
            int localMax = 1;

            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                        duplicatePoints++;
                    } else {
                        double slope = calculateSlope(points[i], points[j]);
                        slopeCount.put(slope, slopeCount.getOrDefault(slope, 1) + 1);
                        localMax = Math.max(localMax, slopeCount.get(slope));
                    }
                }
            }

            maxPoints = Math.max(maxPoints, localMax + duplicatePoints);
        }

        return maxPoints;
    }

    private double calculateSlope(int[] point1, int[] point2) {
        if (point1[0] == point2[0]) {
            return Double.POSITIVE_INFINITY; // Vertical line.
        }
        return (double) (point2[1] - point1[1]) / (point2[0] - point1[0]);
    }

    public static void main(String[] args) {
        MaxPointOnLine solution = new MaxPointOnLine();
        int[][] points = { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };
        int maxPoints = solution.maxPoints(points);
        System.out.println("Maximum points on the same line: " + maxPoints);
    }
}
