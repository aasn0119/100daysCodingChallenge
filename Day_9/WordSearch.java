package Day_9;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // Iterate through the grid and check if the word exists starting from each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true; // If found, return true
                }
            }
        }

        return false; // If not found, return false
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        int m = board.length;
        int n = board[0].length;

        // Check if the current cell is out of bounds or does not match the current
        // character in the word
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index)) {
            return false;
        }

        // If the current character matches, mark it as visited (e.g., change it to a
        // special character)
        char temp = board[i][j];
        board[i][j] = ' ';

        // If we've reached the end of the word, return true
        if (index == word.length() - 1) {
            return true;
        }

        // Explore adjacent cells in four directions
        boolean found = dfs(board, i - 1, j, word, index + 1) || // Up
                dfs(board, i + 1, j, word, index + 1) || // Down
                dfs(board, i, j - 1, word, index + 1) || // Left
                dfs(board, i, j + 1, word, index + 1); // Right

        // Restore the original character in the grid
        board[i][j] = temp;

        return found;
    }

    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word = "ABCCED";
        boolean exists = solution.exist(board, word);
        System.out.println("Word exists: " + exists);
    }
}
