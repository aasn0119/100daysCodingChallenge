package Day_61;

public class RangeSumBST {

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }

        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }

        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        int low = 7;
        int high = 15;

        int sum = rangeSumBST(root, low, high);
        System.out.println("Sum of values in range [" + low + ", " + high + "]: " + sum);
    }
}
