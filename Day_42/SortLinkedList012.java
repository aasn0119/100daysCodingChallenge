package Day_42;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class SortLinkedList012 {

    public ListNode sortList(ListNode head) {
        int[] count = new int[3];
        ListNode current = head;

        // Count the occurrences of 0s, 1s, and 2s
        while (current != null) {
            count[current.val]++;
            current = current.next;
        }

        // Update the linked list with sorted values
        current = head;
        for (int i = 0; i < 3; i++) {
            while (count[i]-- > 0) {
                current.val = i;
                current = current.next;
            }
        }

        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);
        // 1 -> 0 -> 2 -> 1 -> 2
        SortLinkedList012 sorter = new SortLinkedList012();
        System.out.println("Original Linked List:");
        printList(head);

        ListNode sortedList = sorter.sortList(head);

        System.out.println("Sorted Linked List:");
        printList(sortedList);
    }
}
