package Day_50;

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

public class ModifyLinkedList {

    public ListNode modifyLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode evenHead = new ListNode(0);
        ListNode oddHead = new ListNode(0);
        ListNode evenTail = evenHead;
        ListNode oddTail = oddHead;

        while (head != null) {
            if (head.val % 2 == 0) {
                evenTail.next = head;
                evenTail = evenTail.next;
            } else {
                oddTail.next = head;
                oddTail = oddTail.next;
            }
            head = head.next;
        }

        evenTail.next = oddHead.next;
        oddTail.next = null; // Set the next of the last odd node to null to avoid cycles

        return evenHead.next;
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

        ModifyLinkedList modifier = new ModifyLinkedList();
        ListNode result = modifier.modifyLinkedList(head);

        System.out.println("Original List:");
        printList(head);

        System.out.println("Modified List:");
        printList(result);
    }
}
