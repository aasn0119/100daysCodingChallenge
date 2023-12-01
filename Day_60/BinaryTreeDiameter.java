package Day_60;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeDiameter {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateDiameter(root);
        return diameter;
    }

    private int calculateDiameter(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Calculate the depth of the left and right subtrees
        int leftDepth = calculateDiameter(node.left);
        int rightDepth = calculateDiameter(node.right);

        // Update the diameter if the sum of left and right depths is greater
        diameter = Math.max(diameter, leftDepth + rightDepth);

        // Return the depth of the current subtree
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        BinaryTreeDiameter solution = new BinaryTreeDiameter();

        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int result = solution.diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree: " + result);
    }
}
