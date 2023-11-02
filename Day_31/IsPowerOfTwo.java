
public class IsPowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false; // Negative numbers and zero are not powers of two.
        }

        // A power of two has only one bit set in its binary representation.
        // For example: 2^3 = 8 is 1000 in binary.
        // If you subtract 1 from a power of two, you get a binary number with all the
        // bits to the right set to 1.
        // For example: 8 - 1 = 7 is 0111 in binary.
        // If you perform a bitwise AND operation between the original number and the
        // number minus 1, you should get 0.
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println("Is " + n + " power of two: " + isPowerOfTwo(n));
    }

}
