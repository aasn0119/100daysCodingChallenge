package Day_14;

import java.util.Stack;

public class IsValidParenthesis {

    // brute force approach -> O(N^2)
    public static Boolean isValidParenthesis(String s) {

        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        }

        return s.isEmpty();
    }

    // optimized approach O(N) and O(n)
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); // Push opening brackets onto the stack.
            } else {
                if (stack.isEmpty()) {
                    return false; // If a closing bracket is encountered without a corresponding opening bracket,
                                  // it's invalid.
                }

                char top = stack.pop(); // Pop the top element from the stack.

                if (c == ')' && top != '(')
                    return false;
                if (c == '}' && top != '{')
                    return false;
                if (c == ']' && top != '[')
                    return false;
            }
        }

        return stack.isEmpty(); // The string is valid if the stack is empty at the end.
    }

    public static void main(String[] args) {
        String str = "(}";
        System.out.println("Is this a Valid Parenthesis: " + isValidParenthesis(str));
        System.out.println("Is this a Valid Parenthesis: " + isValid(str));
    }
}
