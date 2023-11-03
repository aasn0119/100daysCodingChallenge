package Day_32;

import java.util.HashSet;
import java.util.Set;

public class SquareFormation {
    public static void main(String[] args) {
        int[] p1 = { 0, 0 };
        int[] p2 = { 1, 1 };
        int[] p3 = { 1, 0 };
        int[] p4 = { 0, 1 };
        boolean result = validSquare(p1, p2, p3, p4);
        System.out.println("Is it a valid square? " + result);
    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // We use a set to store the distances between the points
        Set<Integer> set = new HashSet<>();
        // Calculate the distances between all pairs of points and add them to the set
        set.add(distanceSquare(p1, p2));
        set.add(distanceSquare(p1, p3));
        set.add(distanceSquare(p1, p4));
        set.add(distanceSquare(p2, p3));
        set.add(distanceSquare(p2, p4));
        set.add(distanceSquare(p3, p4));
        // A square must have 4 equal sides, so the set must contain 2 different values
        // (the lengths of the sides and the diagonals)
        // The set should not contain 0, as that would mean that two points have the
        // same coordinates
        return !set.contains(0) && set.size() == 2;
    }

    // This method calculates the distance between two points and returns its square
    private static int distanceSquare(int[] a, int[] b) {
        // We use the Pythagorean theorem to calculate the distance between the points
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
