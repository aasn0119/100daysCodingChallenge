package Day_53;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DequeOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();

        while (q-- > 0) {
            String query = scanner.next();

            switch (query) {
                case "pb":
                    int x = scanner.nextInt();
                    pushBack(deque, x);
                    break;
                case "pf":
                    int y = scanner.nextInt();
                    pushFront(deque, y);
                    break;
                case "pp_b":
                    popBack(deque);
                    break;
                case "f":
                    System.out.println(front(deque));
                    break;
            }
        }

        scanner.close();
    }

    private static void pushBack(Deque<Integer> deque, int x) {
        deque.addLast(x);
    }

    private static void pushFront(Deque<Integer> deque, int x) {
        deque.addFirst(x);
    }

    private static void popBack(Deque<Integer> deque) {
        if (!deque.isEmpty()) {
            deque.removeLast();
        }
    }

    private static int front(Deque<Integer> deque) {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }
}
