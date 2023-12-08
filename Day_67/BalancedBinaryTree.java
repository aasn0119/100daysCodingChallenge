package Day_67;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        // Base case: an empty tree is balanced
        if (root == null) {
            return true;
        }

        // Check if the left and right subtrees are balanced
        boolean leftBalanced = isBalanced(root.left);
        boolean rightBalanced = isBalanced(root.right);

        // Check if the current subtree is balanced
        boolean currentBalanced = Math.abs(height(root.left) - height(root.right)) <= 1;

        // Return true if the current subtree and both subtrees are balanced
        return currentBalanced && leftBalanced && rightBalanced;
    }

    private int height(TreeNode node) {
        // Base case: the height of an empty tree is 0
        if (node == null) {
            return 0;
        }

        // Recursively calculate the height of the subtree
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Return the height of the subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        BalancedBinaryTree solution = new BalancedBinaryTree();
        boolean result = solution.isBalanced(root);

        System.out.println("Is the tree balanced? " + result);
    }
}
