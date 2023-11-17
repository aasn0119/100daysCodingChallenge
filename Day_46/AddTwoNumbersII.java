package Day_46;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Use two stacks to store the digits
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // Push digits of the first number onto stack1
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        // Push digits of the second number onto stack2
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        // Initialize variables for the sum and carry
        int sum = 0;
        int carry = 0;

        // Use a dummy node to build the result linked list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Process the digits from the least significant digit to the most significant
        // digit
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            // Get the digits from the stacks
            int digit1 = stack1.isEmpty() ? 0 : stack1.pop();
            int digit2 = stack2.isEmpty() ? 0 : stack2.pop();

            // Calculate the sum and carry
            sum = digit1 + digit2 + carry;
            carry = sum / 10;

            // Create a new node with the current digit and update the result linked list
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = current.next;
            current.next = newNode;
        }

        return dummy.next;
    }

    // Helper method to print a linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbersII adder = new AddTwoNumbersII();
        ListNode result = adder.addTwoNumbers(l1, l2);

        System.out.println("Input 1: ");
        printList(l1);

        System.out.println("Input 2: ");
        printList(l2);

        System.out.println("Sum: ");
        printList(result);
    }
}
