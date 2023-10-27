package Day_25;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int numIslands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numIslands++; // Found a new island, increment the count
                    dfs(grid, i, j); // Start DFS to mark all connected land cells
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return; // Out of bounds or water, so return
        }

        grid[row][col] = '0'; // Mark the current land as visited

        // Recursively visit adjacent lands in all 8 directions
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
        dfs(grid, row - 1, col - 1);
        dfs(grid, row - 1, col + 1);
        dfs(grid, row + 1, col - 1);
        dfs(grid, row + 1, col + 1);
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        int numIslands = solution.numIslands(grid);
        System.out.println("Number of Islands: " + numIslands);
    }
}
