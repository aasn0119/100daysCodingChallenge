package Day_17;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(n, n, "", result);
        return result;
    }

    private void generateParenthesisHelper(int left, int right, String current, List<String> result) {
        // Base case: If both left and right parentheses are used up, add the current
        // combination to the result.
        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }

        // Recursive case: Add an opening parenthesis "(" if there are remaining left
        // parentheses.
        if (left > 0) {
            generateParenthesisHelper(left - 1, right, current + "(", result);
        }

        // Add a closing parenthesis ")" if there are more remaining right parentheses
        // than left.
        if (right > left) {
            generateParenthesisHelper(left, right - 1, current + ")", result);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generator = new GenerateParentheses();
        int n = 3;
        List<String> combinations = generator.generateParenthesis(n);

        System.out.println("Combinations of well-formed parentheses for n = " + n + ":");
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }
}
