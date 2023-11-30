import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int topElement;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
        topElement = x;
    }

    /** Removes the element on the top of the stack and returns that element. */
    public int pop() {
        while (queue1.size() > 1) {
            topElement = queue1.poll();
            queue2.offer(topElement);
        }

        int poppedElement = queue1.poll();

        // Swap the references of queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return poppedElement;
    }

    /** Get the top element. */
    public int top() {
        return topElement;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
