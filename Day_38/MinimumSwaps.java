package Day_38;

public class MinimumSwaps {
    public static int minSwaps(int[] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i] == i + 1) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j] - 1;
                cycleSize++;
            }

            swaps += (cycleSize - 1);
        }

        return swaps;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 1, 2 };
        int result = minSwaps(arr);
        System.out.println("Minimum swaps required: " + result); // Output: 2
    }
}
