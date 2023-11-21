package Day_50;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeSortLinkedList {

    // Merge two sorted linked lists
    private Node merge(Node left, Node right) {
        if (left == null)
            return right;
        if (right == null)
            return left;

        Node result;
        if (left.data <= right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
    }

    // Split the linked list into two halves
    private Node[] split(Node head) {
        if (head == null || head.next == null) {
            return new Node[] { head, null };
        }

        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node left = head;
        Node right = slow.next;
        slow.next = null;

        return new Node[] { left, right };
    }

    // Merge Sort implementation
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node[] splitNodes = split(head);
        Node left = mergeSort(splitNodes[0]);
        Node right = mergeSort(splitNodes[1]);

        return merge(left, right);
    }

    // Helper method to print the linked list
    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage
        Node head = new Node(12);
        head.next = new Node(11);
        head.next.next = new Node(13);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(6);

        MergeSortLinkedList sorter = new MergeSortLinkedList();
        head = sorter.mergeSort(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}
