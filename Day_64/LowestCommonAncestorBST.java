class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // If both nodes are smaller than the root, LCA must be in the left subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // If both nodes are greater than the root, LCA must be in the right subtree
        else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // If one node is smaller and the other is greater, or one of them is equal to
        // the root, then root is the LCA
        else {
            return root;
        }
    }

    public static void main(String[] args) {
        // Example usage:
        // Construct a sample Binary Search Tree
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        // Nodes for which LCA needs to be found
        TreeNode p = root.left; // Example: Node with value 10
        TreeNode q = root.right.right; // Example: Node with value 35

        // Create an instance of the class
        LowestCommonAncestorBST lcaFinder = new LowestCommonAncestorBST();

        // Find the lowest common ancestor
        TreeNode lca = lcaFinder.lowestCommonAncestor(root, p, q);

        // Print the value of the lowest common ancestor
        System.out.println("Lowest Common Ancestor: " + lca.val);
    }
}
