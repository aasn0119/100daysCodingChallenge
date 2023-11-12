class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class BinaryLinkedListToDecimal {

    public int getDecimalValue(ListNode head) {
        int result = 0;

        while (head != null) {
            result = result * 2 + head.val; // Convert binary to decimal
            head = head.next;
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);

        BinaryLinkedListToDecimal converter = new BinaryLinkedListToDecimal();
        int decimalValue = converter.getDecimalValue(head);

        System.out.println("Decimal value of the binary linked list: " + decimalValue);
    }
}
