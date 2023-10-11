package Day_9;

import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int rowBeg = 0, rowEnd = matrix.length - 1;
        int colBeg = 0, colEnd = matrix[0].length - 1;

        while (rowBeg <= rowEnd && colBeg <= colEnd) {
            // Traverse top row from left to right
            for (int i = colBeg; i <= colEnd; i++) {
                result.add(matrix[rowBeg][i]);
            }
            rowBeg++;

            // Traverse right column from top to bottom
            for (int i = rowBeg; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            // Check if there's a bottom row to traverse
            if (rowBeg <= rowEnd) {
                // Traverse bottom row from right to left
                for (int i = colEnd; i >= colBeg; i--) {
                    result.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }

            // Check if there's a left column to traverse
            if (colBeg <= colEnd) {
                // Traverse left column from bottom to top
                for (int i = rowEnd; i >= rowBeg; i--) {
                    result.add(matrix[i][colBeg]);
                }
                colBeg++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println(result);
    }
}
