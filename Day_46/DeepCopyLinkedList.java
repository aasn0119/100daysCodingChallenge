package Day_46;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
    }
}

public class DeepCopyLinkedList {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Duplicate each node and insert it after the original node
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

        // Step 2: Set random pointers for the new nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the modified list into original and copied lists
        Node newHead = head.next;
        current = head;
        while (current != null) {
            Node temp = current.next;
            current.next = temp.next;
            current = current.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }

        return newHead;
    }

    // Helper method to print the linked list
    private static void printList(Node head) {
        while (head != null) {
            System.out.print("(" + head.val + ", ");
            System.out.print((head.random != null ? head.random.val : "null") + ") -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example usage
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;
        node1.random = node3;
        node2.random = node1;
        node3.random = node2;

        DeepCopyLinkedList copier = new DeepCopyLinkedList();
        Node copiedHead = copier.copyRandomList(node1);

        System.out.println("Original List:");
        printList(node1);

        System.out.println("Copied List:");
        printList(copiedHead);
    }
}
