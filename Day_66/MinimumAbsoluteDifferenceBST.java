class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class MinimumAbsoluteDifferenceBST {
    // Global variable to store the minimum absolute difference
    private int minDiff = Integer.MAX_VALUE;
    // Variable to store the previous node during traversal
    private TreeNode prevNode;

    public int getMinimumDifference(TreeNode root) {
        // Start the in-order traversal
        inorderTraversal(root);
        return minDiff;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree
        inorderTraversal(node.left);

        // Update the minimum absolute difference
        if (prevNode != null) {
            minDiff = Math.min(minDiff, Math.abs(node.val - prevNode.val));
        }

        // Update the previous node
        prevNode = node;

        // Traverse the right subtree
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        MinimumAbsoluteDifferenceBST solution = new MinimumAbsoluteDifferenceBST();
        int result = solution.getMinimumDifference(root);

        System.out.println("Minimum Absolute Difference: " + result);
    }
}
