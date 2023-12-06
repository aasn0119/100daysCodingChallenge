class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // Check if the current node is a leaf
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Recursively check left and right subtrees
        boolean leftResult = hasPathSum(root.left, targetSum - root.val);
        boolean rightResult = hasPathSum(root.right, targetSum - root.val);

        return leftResult || rightResult;
    }

    public static void main(String[] args) {
        // Example usage:
        // Construct a sample binary tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        // Create an instance of the class
        PathSum pathSumChecker = new PathSum();

        // Check if there is a root-to-leaf path with the target sum
        boolean result = pathSumChecker.hasPathSum(root, targetSum);

        // Print the result
        System.out.println("Does the tree have a root-to-leaf path with sum " + targetSum + "? " + result);
    }
}
