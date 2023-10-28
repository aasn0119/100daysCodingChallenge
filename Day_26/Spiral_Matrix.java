package Day_26;

public class Spiral_Matrix {
    public static void main(String[] args) {
        int n = 4; // Change the value of n for different matrix sizes
        int[][] spiralMatrix = generateSpiralMatrix(n);

        // Print the generated spiral matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(spiralMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] generateSpiralMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int num = 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }

        return matrix;
    }
}
