class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Use two pointers, one moving at normal speed, and the other moving at double speed
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If there is a cycle, the two pointers will eventually meet
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Creating a cycle

        LinkedListCycle cycleChecker = new LinkedListCycle();
        boolean hasCycle = cycleChecker.hasCycle(head);

        System.out.println("Does the linked list have a cycle? " + hasCycle);
    }
}
