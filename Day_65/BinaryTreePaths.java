package Day_65;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            dfs(root, "", result);
        }
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        if (node.left == null && node.right == null) {
            // If the node is a leaf, add the path to the result
            result.add(path + node.val);
        }

        if (node.left != null) {
            // Recursively traverse the left subtree
            dfs(node.left, path + node.val + "->", result);
        }

        if (node.right != null) {
            // Recursively traverse the right subtree
            dfs(node.right, path + node.val + "->", result);
        }
    }

    public static void main(String[] args) {
        // Example usage:
        // Construct a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        // Create an instance of the class
        BinaryTreePaths pathFinder = new BinaryTreePaths();

        // Get all root-to-leaf paths
        List<String> paths = pathFinder.binaryTreePaths(root);

        // Print the result
        System.out.println("Root-to-leaf paths: " + paths);
    }
}
