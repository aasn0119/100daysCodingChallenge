package Day_12;

public class Combinations {
    public static void generateCombinations(int[] arr, int n, int r, int index, int[] data, int dataIndex) {
        // If a combination of r elements is generated, print it
        if (dataIndex == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
            return;
        }

        // If there are no more elements to consider or we have filled all available
        // slots, return
        if (index >= n || r - dataIndex > n - index) {
            return;
        }

        // Include the current element in the combination and recursively generate the
        // next combination
        data[dataIndex] = arr[index];
        generateCombinations(arr, n, r, index + 1, data, dataIndex + 1);

        // Exclude the current element and generate combinations without it
        generateCombinations(arr, n, r, index + 1, data, dataIndex);
    }

    public static void printCombinations(int[] arr, int n, int r) {
        int[] data = new int[r];
        generateCombinations(arr, n, r, 0, data, 0);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int n = arr.length;
        int r = 3; // Number of elements in each combination
        printCombinations(arr, n, r);
    }
}
