package Day_45;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class DeleteNodeInLinkedList {

    public void deleteNode(ListNode nodeToDelete) {
        if (nodeToDelete == null || nodeToDelete.next == null) {
            // Cannot delete the node or the last node
            return;
        }

        // Copy the value of the next node to the current node
        nodeToDelete.val = nodeToDelete.next.val;

        // Delete the next node
        nodeToDelete.next = nodeToDelete.next.next;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode nodeToDelete = head.next;

        System.out.println("Original Linked List:");
        printLinkedList(head);

        DeleteNodeInLinkedList deleter = new DeleteNodeInLinkedList();
        deleter.deleteNode(nodeToDelete);

        System.out.println("Linked List after deleting node with value " + nodeToDelete.val + ":");
        printLinkedList(head);
    }

    private static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
