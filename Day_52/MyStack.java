import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue1; // Main queue
    private Queue<Integer> queue2; // Auxiliary queue

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        // Add the new element to the non-empty queue
        if (!queue1.isEmpty()) {
            queue1.add(x);
        } else {
            queue2.add(x);
        }
    }

    /** Removes the element on the top of the stack and returns that element. */
    public int pop() {
        // Move all elements except the last one to the auxiliary queue
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        // Remove and return the last element from the main queue
        int poppedElement = queue1.poll();

        // Swap the queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return poppedElement;
    }

    /** Get the top element. */
    public int top() {
        // Move all elements except the last one to the auxiliary queue
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        // Get and return the last element from the main queue
        int topElement = queue1.peek();

        // Move the last element to the auxiliary queue
        queue2.add(queue1.poll());

        // Swap the queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        myStack.push(1);
        myStack.push(2);
        System.out.println("Top: " + myStack.top()); // Output: 2
        System.out.println("Pop: " + myStack.pop()); // Output: 2
        System.out.println("Empty: " + myStack.empty()); // Output: false
    }
}
