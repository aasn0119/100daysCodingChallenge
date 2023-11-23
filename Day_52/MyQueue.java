import java.util.Stack;

class MyQueue {

    private Stack<Integer> stack1; // Used for pushing elements
    private Stack<Integer> stack2; // Used for popping and peeking elements

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of the queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from the front of the queue and returns it. */
    public int pop() {
        // Ensure stack2 is not empty before popping
        if (stack2.isEmpty()) {
            // Transfer elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // Pop from stack2
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        // Ensure stack2 is not empty before peeking
        if (stack2.isEmpty()) {
            // Transfer elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // Peek from stack2
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        // Both stacks must be empty for the queue to be empty
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        myQueue.push(1);
        myQueue.push(2);
        System.out.println("Peek: " + myQueue.peek()); // Output: 1
        System.out.println("Pop: " + myQueue.pop());   // Output: 1
        System.out.println("Empty: " + myQueue.empty()); // Output: false
    }
}
