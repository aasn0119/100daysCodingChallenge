package Day_65;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, they are equal
        if (p == null && q == null) {
            return true;
        }
        // If one of the nodes is null and the other is not, they are not equal
        else if (p == null || q == null) {
            return false;
        }
        // If the values are not equal, they are not equal
        else if (p.val != q.val) {
            return false;
        }
        // Recursively check left and right subtrees
        else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public static void main(String[] args) {
        // Example usage:
        // Construct two sample binary trees
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);

        // Create an instance of the class
        SameTree treeComparator = new SameTree();

        // Check if the trees are the same
        boolean result = treeComparator.isSameTree(tree1, tree2);

        // Print the result
        System.out.println("Are the trees the same? " + result);
    }
}
