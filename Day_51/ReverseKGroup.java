class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReverseKGroup {

    // Helper method to reverse a linked list
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != tail) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    // Reverse nodes in k-group
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        ListNode curr = head;
        int count = 0;

        // Count the number of nodes in the list
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        while (count >= k) {
            ListNode groupStart = prevGroupEnd.next;
            ListNode groupEnd = curr;
            curr = curr.next;

            // Reverse the current group
            ListNode reversedGroup = reverse(groupStart, groupEnd);

            // Connect the reversed group to the previous and next groups
            prevGroupEnd.next = reversedGroup;
            groupStart.next = curr;

            // Move to the next group
            prevGroupEnd = groupStart;
            count -= k;
        }

        return dummy.next;
    }

    // Helper method to print the linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        ReverseKGroup reverser = new ReverseKGroup();
        head = reverser.reverseKGroup(head, k);

        System.out.println("Reversed List in K-Groups:");
        printList(head);
    }
}
