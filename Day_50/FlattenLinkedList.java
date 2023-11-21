package Day_50;

class Node {
    int data;
    Node right, down;

    Node(int data) {
        this.data = data;
        this.right = null;
        this.down = null;
    }
}

public class FlattenLinkedList {

    // Helper function to merge two sorted linked lists
    private Node merge(Node a, Node b) {
        if (a == null)
            return b;
        if (b == null)
            return a;

        Node result;
        if (a.data < b.data) {
            result = a;
            result.down = merge(a.down, b);
        } else {
            result = b;
            result.down = merge(a, b.down);
        }

        return result;
    }

    // Function to flatten the given linked list
    public Node flatten(Node root) {
        if (root == null || root.right == null) {
            return root;
        }

        // Recursively flatten the right and down linked lists
        root.right = flatten(root.right);
        root = merge(root, root.right);

        return root;
    }

    // Helper method to print the flattened linked list
    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.down;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage
        Node head = new Node(5);
        head.right = new Node(10);
        head.right.right = new Node(19);
        head.right.right.right = new Node(28);

        head.down = new Node(7);
        head.down.down = new Node(8);
        head.down.down.down = new Node(30);

        head.right.down = new Node(20);

        head.right.right.down = new Node(22);
        head.right.right.down.down = new Node(50);

        FlattenLinkedList flattener = new FlattenLinkedList();
        head = flattener.flatten(head);

        System.out.println("Flattened List:");
        printList(head);
    }
}
