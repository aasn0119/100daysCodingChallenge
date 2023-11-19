class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class PartitionLinkedList {

    public ListNode partition(ListNode head, int x) {
        // Create two dummy nodes for the less than and greater/equal partitions
        ListNode lessThanXDummy = new ListNode(0);
        ListNode greaterEqualXDummy = new ListNode(0);

        // Create pointers for the two partitions
        ListNode lessThanX = lessThanXDummy;
        ListNode greaterEqualX = greaterEqualXDummy;

        // Traverse the original list
        while (head != null) {
            if (head.val < x) {
                // Append to the less than x partition
                lessThanX.next = head;
                lessThanX = lessThanX.next;
            } else {
                // Append to the greater or equal to x partition
                greaterEqualX.next = head;
                greaterEqualX = greaterEqualX.next;
            }

            // Move to the next node in the original list
            head = head.next;
        }

        // Connect the partitions and set the end of the greater/equal partition to null
        lessThanX.next = greaterEqualXDummy.next;
        greaterEqualX.next = null;

        // Return the head of the modified list
        return lessThanXDummy.next;
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
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        PartitionLinkedList partitioner = new PartitionLinkedList();
        int x = 3;
        ListNode result = partitioner.partition(head, x);

        System.out.println("Original List:");
        printList(head);

        System.out.println("List after partitioning around " + x + ":");
        printList(result);
    }
}
