package Day_55;

import java.util.Stack;

public class StockSpanner {
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            span += stack.pop()[1];
        }

        stack.push(new int[] { price, span });
        return span;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // 1
        System.out.println(stockSpanner.next(80)); // 1
        System.out.println(stockSpanner.next(60)); // 1
        System.out.println(stockSpanner.next(70)); // 2
        System.out.println(stockSpanner.next(60)); // 1
        System.out.println(stockSpanner.next(75)); // 4
        System.out.println(stockSpanner.next(85)); // 6
    }
}
