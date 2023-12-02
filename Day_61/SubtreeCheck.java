package Day_61;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class SubtreeCheck {

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (root.val != subRoot.val) {
            return false;
        }

        return isSubtree(root.left, subRoot.left) && isSubtree(root.right, subRoot.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode subRoot = new TreeNode(2);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(3);

        System.out.println(isSubtree(root, subRoot)); // Output: true
    }
}
