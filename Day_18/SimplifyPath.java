package Day_18;

import java.util.LinkedList;

public class SimplifyPath {
    public String simplifyPath(String path) {
        // Split the input path by slashes
        String[] parts = path.split("/");
        LinkedList<String> stack = new LinkedList<>();

        for (String part : parts) {
            if (part.equals("..")) {
                // If we encounter '..', pop the last directory from the stack (if it's not
                // empty)
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!part.equals(".") && !part.isEmpty()) {
                // Ignore '.' and empty parts, and push other parts onto the stack
                stack.push(part);
            }
        }

        // Reconstruct the simplified path
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/").append(stack.pollLast());
        }

        // Handle the case where the result is an empty string
        return result.length() > 0 ? result.toString() : "/";
    }

    public static void main(String[] args) {
        SimplifyPath simplifier = new SimplifyPath();
        String path = "/a/./b/../../c/";

        String simplifiedPath = simplifier.simplifyPath(path);
        System.out.println("Simplified Canonical Path: " + simplifiedPath);
    }
}
