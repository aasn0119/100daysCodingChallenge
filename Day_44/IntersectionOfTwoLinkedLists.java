package Day_44;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        int diff = Math.abs(lenA - lenB);

        if (lenA > lenB) {
            headA = movePointer(headA, diff);
        } else {
            headB = movePointer(headB, diff);
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    private ListNode movePointer(ListNode head, int steps) {
        while (steps > 0) {
            head = head.next;
            steps--;
        }
        return head;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode commonNode = new ListNode(8);
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = commonNode;
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = commonNode;

        IntersectionOfTwoLinkedLists intersectionFinder = new IntersectionOfTwoLinkedLists();
        ListNode result = intersectionFinder.getIntersectionNode(headA, headB);

        System.out.println("Intersection Node Value: " + (result != null ? result.val : "null"));
    }
}
