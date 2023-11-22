class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class SubtractLinkedLists {

    // Subtract smaller linked list from larger linked list
    public ListNode subtract(ListNode l1, ListNode l2) {
        int len1 = getLength(l1);
        int len2 = getLength(l2);

        // Ensure l1 is always the larger or equal length list
        if (len1 < len2) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        // Pad the smaller linked list with leading zeros
        l2 = padZeros(l2, Math.abs(len1 - len2));

        // Helper method to perform subtraction of linked lists
        ListNode result = subtractLists(l1, l2);

        // Remove leading zeros from the result
        result = removeLeadingZeros(result);

        return result;
    }

    // Helper method to get the length of a linked list
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    // Helper method to pad zeros to the smaller linked list
    private ListNode padZeros(ListNode head, int zeros) {
        while (zeros > 0) {
            ListNode zeroNode = new ListNode(0);
            zeroNode.next = head;
            head = zeroNode;
            zeros--;
        }
        return head;
    }

    // Helper method to perform subtraction of linked lists
    private ListNode subtractLists(ListNode l1, ListNode l2) {
        int borrow = 0;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null) {
            int diff = l1.val - l2.val - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            current.next = new ListNode(diff);
            current = current.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        return dummy.next;
    }

    // Helper method to remove leading zeros from the result
    private ListNode removeLeadingZeros(ListNode head) {
        while (head != null && head.val == 0) {
            head = head.next;
        }
        return (head == null) ? new ListNode(0) : head;
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
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(7);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(2);

        SubtractLinkedLists subtractor = new SubtractLinkedLists();
        ListNode result = subtractor.subtract(l1, l2);

        System.out.println("Subtraction Result:");
        printList(result);
    }
}
