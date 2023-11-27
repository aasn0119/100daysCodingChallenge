import java.util.LinkedList;
import java.util.Queue;

public class NearestDistance {
    public int[][] nearestDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] result = new int[rows][cols];

        Queue<int[]> queue = new LinkedList<>();

        // Add all 1s to the queue and mark them as visited
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] { i, j });
                    result[i][j] = 0; // Distance to itself is 0
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] dir : directions) {
                int newRow = curr[0] + dir[0];
                int newCol = curr[1] + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                        result[newRow][newCol] > result[curr[0]][curr[1]] + 1) {
                    result[newRow][newCol] = result[curr[0]][curr[1]] + 1;
                    queue.offer(new int[] { newRow, newCol });
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        NearestDistance solution = new NearestDistance();
        int[][] grid = { { 0, 1, 0, 0, 1 }, { 0, 0, 0, 1, 0 }, { 0, 1, 1, 0, 1 }, { 1, 0, 0, 1, 0 } };
        int[][] result = solution.nearestDistance(grid);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
