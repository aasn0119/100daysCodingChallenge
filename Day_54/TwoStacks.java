public class TwoStacks {
    private int[] array;
    private int top1, top2;
    private int size;

    public TwoStacks(int capacity) {
        array = new int[capacity];
        size = capacity;
        top1 = -1;
        top2 = size;
    }

    public void push1(int x) {
        if (top1 < top2 - 1) {
            array[++top1] = x;
        } else {
            System.out.println("Stack Overflow: Cannot push into stack 1");
        }
    }

    public void push2(int x) {
        if (top1 < top2 - 1) {
            array[--top2] = x;
        } else {
            System.out.println("Stack Overflow: Cannot push into stack 2");
        }
    }

    public int pop1() {
        if (top1 >= 0) {
            return array[top1--];
        } else {
            System.out.println("Stack 1 is empty");
            return Integer.MIN_VALUE;
        }
    }

    public int pop2() {
        if (top2 < size) {
            return array[top2++];
        } else {
            System.out.println("Stack 2 is empty");
            return Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) {
        TwoStacks twoStacks = new TwoStacks(5);

        twoStacks.push1(1);
        twoStacks.push2(2);
        twoStacks.push1(3);
        twoStacks.push2(4);
        twoStacks.push1(5);

        System.out.println("Popped from stack 1: " + twoStacks.pop1());
        System.out.println("Popped from stack 2: " + twoStacks.pop2());
        System.out.println("Popped from stack 1: " + twoStacks.pop1());
    }
}
