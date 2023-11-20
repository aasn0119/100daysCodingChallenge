package Day_49;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class DeleteDuplicatesSortedLinkedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0); // Dummy node to handle the case when the head needs to be deleted
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            boolean hasDuplicates = false;

            // Check if there are duplicates in the current section
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
                hasDuplicates = true;
            }

            if (hasDuplicates) {
                prev.next = head.next; // Skip the entire section with duplicates
            } else {
                prev = prev.next; // Move the pointer to the next distinct node
            }

            head = head.next; // Move to the next node in the list
        }

        return dummy.next;
    }

    // Helper method to print the linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        DeleteDuplicatesSortedLinkedList deleter = new DeleteDuplicatesSortedLinkedList();
        ListNode result = deleter.deleteDuplicates(head);

        System.out.println("Original List:");
        printList(head);

        System.out.println("List after deleting duplicates:");
        printList(result);
    }
}
