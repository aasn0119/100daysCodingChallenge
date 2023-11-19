class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}

public class FlattenMultilevelLinkedList {

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Node dummy = new Node(0, null, head, null);
        flattenDFS(dummy, head);

        // Detach the dummy node from the result list
        dummy.next.prev = null;
        return dummy.next;
    }

    private Node flattenDFS(Node prev, Node curr) {
        if (curr == null) {
            return prev;
        }

        // Connect current node to the previous node
        curr.prev = prev;
        prev.next = curr;

        // Save the next node in the original list
        Node tempNext = curr.next;

        // Connect child list if present
        if (curr.child != null) {
            Node tail = flattenDFS(curr, curr.child);
            curr.child = null; // Set child pointer to null after flattening
            tail.next = tempNext; // Connect the flattened child list to the next node in the original list
            if (tempNext != null) {
                tempNext.prev = tail; // Update the previous pointer of the next node
            }
        }

        // Continue flattening the rest of the list
        return flattenDFS(curr, tempNext);
    }

    // Helper method to print the flattened list
    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " <-> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example usage
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.prev = head.next.next.next;
        head.child = new Node(6);
        head.child.next = new Node(7);
        head.child.next.prev = head.child;
        head.child.child = new Node(8);
        head.child.child.next = new Node(9);
        head.child.child.next.prev = head.child.child;

        FlattenMultilevelLinkedList flattener = new FlattenMultilevelLinkedList();
        Node result = flattener.flatten(head);

        System.out.println("Original List:");
        printList(head);

        System.out.println("Flattened List:");
        printList(result);
    }
}
