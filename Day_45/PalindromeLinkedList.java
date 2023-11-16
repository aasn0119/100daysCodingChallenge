package Day_45;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            // An empty list or a single-node list is considered a palindrome
            return true;
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        ListNode secondHalf = reverseList(slow);

        // Step 3: Compare the first half with the reversed second half
        while (secondHalf != null) {
            if (head.val != secondHalf.val) {
                return false;
            }
            head = head.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        PalindromeLinkedList palindromeChecker = new PalindromeLinkedList();
        System.out.println("Is the linked list a palindrome? " + palindromeChecker.isPalindrome(head));
    }
}
