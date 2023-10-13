package Day_12;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Create a copy of the board to store the next state
        int[][] nextBoard = new int[m][n];

        // Define eight directions for neighbors
        int[] directions = { -1, 0, 1 };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                // Iterate through the eight neighbors of the current cell
                for (int dx : directions) {
                    for (int dy : directions) {
                        if (dx == 0 && dy == 0)
                            continue; // Skip the current cell
                        int ni = i + dx;
                        int nj = j + dy;

                        // Check if the neighbor is valid
                        if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                            liveNeighbors += board[ni][nj];
                        }
                    }
                }

                // Apply the Game of Life rules to update the next state
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        nextBoard[i][j] = 0; // Rule 1 and 3
                    } else {
                        nextBoard[i][j] = 1; // Rule 2
                    }
                } else {
                    if (liveNeighbors == 3) {
                        nextBoard[i][j] = 1; // Rule 4
                    } else {
                        nextBoard[i][j] = 0;
                    }
                }
            }
        }

        // Copy the next state back to the original board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = nextBoard[i][j];
            }
        }
    }

    public static void main(String[] args) {
        GameOfLife solution = new GameOfLife();
        int[][] board = {
                { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 1, 1 },
                { 0, 0, 0 }
        };
        solution.gameOfLife(board);

        // Print the updated state of the board
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
