package Day_67;

class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int key) {
        this.key = key;
    }
}

public class InOrderSuccessorPredecessor {
    TreeNode predecessor, successor;

    public void findPredecessorSuccessor(TreeNode root, int key) {
        // Start the in-order traversal
        inOrderTraversal(root, key);

        // If predecessor or successor is not found, set it to NULL
        if (predecessor == null) {
            System.out.println("Predecessor: NULL");
        } else {
            System.out.println("Predecessor: " + predecessor.key);
        }

        if (successor == null) {
            System.out.println("Successor: NULL");
        } else {
            System.out.println("Successor: " + successor.key);
        }
    }

    private void inOrderTraversal(TreeNode node, int key) {
        if (node == null) {
            return;
        }

        // Recursively traverse the left subtree
        inOrderTraversal(node.left, key);

        // Check if the current node is the predecessor or successor
        if (node.key == key) {
            findSuccessor(node.right);
            findPredecessor(node.left);
        } else if (node.key < key) {
            // Update predecessor and continue traversal in the right subtree
            predecessor = node;
            inOrderTraversal(node.right, key);
        } else {
            // Update successor and continue traversal in the left subtree
            successor = node;
            inOrderTraversal(node.left, key);
        }
    }

    private void findSuccessor(TreeNode node) {
        // Find the leftmost node in the right subtree
        while (node != null && node.left != null) {
            node = node.left;
        }
        successor = node;
    }

    private void findPredecessor(TreeNode node) {
        // Find the rightmost node in the left subtree
        while (node != null && node.right != null) {
            node = node.right;
        }
        predecessor = node;
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        InOrderSuccessorPredecessor solution = new InOrderSuccessorPredecessor();
        solution.findPredecessorSuccessor(root, 40);
    }
}
