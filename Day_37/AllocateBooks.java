package Day_37;

import java.util.*;

public class AllocateBooks {
    public static int books(ArrayList<Integer> A, int B) {
        int n = A.size();
        if (n < B) {
            return -1; // It's not possible to allocate books if students are more than books.
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A.get(i);
        }

        long low = 0;
        long high = sum;
        long result = -1;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isPossible(A, n, B, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) result;
    }

    public static boolean isPossible(ArrayList<Integer> A, int n, int B, long maxPages) {
        int students = 1;
        long pages = 0;

        for (int i = 0; i < n; i++) {
            if (A.get(i) > maxPages) {
                return false;
            }

            if (pages + A.get(i) <= maxPages) {
                pages += A.get(i);
            } else {
                students++;
                pages = A.get(i);
                if (students > B) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> books = new ArrayList<>(Arrays.asList(12, 34, 67, 90));
        int students = 2;
        int result = books(books, students);
        System.out.println("Minimum pages to allocate: " + result);
    }
}
