class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class ReverseLinkedListBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move to the node before the reversal
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Reverse the nodes from left to right
        ListNode current = prev.next;
        ListNode next = null;
        for (int i = left; i <= right; i++) {
            ListNode temp = current.next;
            current.next = next;
            next = current;
            current = temp;
        }

        // Connect the reversed portion back to the list
        prev.next.next = current;
        prev.next = next;

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
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseLinkedListBetween reverser = new ReverseLinkedListBetween();
        int left = 2, right = 4;
        ListNode reversedHead = reverser.reverseBetween(head, left, right);

        System.out.println("Original List:");
        printList(head);

        System.out.println("Reversed List between " + left + " and " + right + ":");
        printList(reversedHead);
    }
}
