package Day_59;

public class CelebrityProblem {
    // Example hypothetical function, replace it with your actual implementation
    private static boolean haveAcquaintance(int a, int b) {
        // Replace this with your actual logic
        return false;
    }

    public static int findCelebrity(int[] party) {
        int n = party.length;
        int left = 0;
        int right = n - 1;

        // Eliminate candidates iteratively
        while (left < right) {
            if (haveAcquaintance(party[left], party[right])) {
                // If left knows right, left cannot be the celebrity
                left++;
            } else {
                // If left doesn't know right, right cannot be the celebrity
                right--;
            }
        }

        // Verify if the potential celebrity is indeed a celebrity
        int potentialCelebrity = party[left];
        for (int i = 0; i < n; i++) {
            if (i != potentialCelebrity
                    && (haveAcquaintance(potentialCelebrity, i) || !haveAcquaintance(i, potentialCelebrity))) {
                return -1; // No celebrity found
            }
        }

        return potentialCelebrity;
    }

    public static void main(String[] args) {
        // Example usage
        int[] party = { 0, 1, 2, 3, 4 };
        int celebrity = findCelebrity(party);

        if (celebrity != -1) {
            System.out.println("The celebrity is person " + celebrity);
        } else {
            System.out.println("No celebrity found");
        }
    }
}
