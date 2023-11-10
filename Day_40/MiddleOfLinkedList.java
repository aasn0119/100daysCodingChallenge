package Day_40;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class MiddleOfLinkedList {

    public ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Move slow pointer one step and fast pointer two steps until fast reaches the
        // end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        MiddleOfLinkedList middleFinder = new MiddleOfLinkedList();
        ListNode middle = middleFinder.findMiddle(head);

        System.out.println("Middle Node Value: " + middle.val);
    }
}
