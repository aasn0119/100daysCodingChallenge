import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 19;
        boolean isHappy = isHappy(n);
        System.out.println("Is " + n + " a happy number? " + isHappy);
    }

    public static boolean isHappy(int n) {
        // Use a HashSet to detect cycles
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNextNumber(n);
        }

        return n == 1;
    }

    public static int getNextNumber(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
