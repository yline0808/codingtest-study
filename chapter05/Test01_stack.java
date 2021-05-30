package chapter05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test01_stack {
    public static void stackEx() {
        System.out.println("=======stack======");
        Stack<Integer> s = new Stack<>();

        s.push(5);
        s.push(2);
        s.push(3);
        s.push(7);
        s.pop();
        s.push(1);
        s.push(4);
        s.pop();

        System.out.println(s.toString());

        while (!s.empty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }

    public static void queueEx() {
        System.out.println("=======queue======");
        Queue<Integer> q = new LinkedList<>();
        q.offer(5);
        q.offer(2);
        q.offer(3);
        q.offer(7);
        q.poll();
        q.offer(1);
        q.offer(4);
        q.poll();

        System.out.println(q.toString());
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }

    public static void recursiveFunction(int i) {
        if (i == 10)
            return;
        System.out.printf("[%d] start : recursive call!!!\n", i);
        recursiveFunction(i + 1);
        System.out.printf("[%d] end : recursive!!!\n", i);
    }

    public static int factorialIterative(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static int factorialRecursive(int n) {
        if (n == 1)
            return 1;
        return n * factorialRecursive(n - 1);
    }

    public static void main(String[] args) {
        stackEx();
        queueEx();
        recursiveFunction(1);
        System.out.println("iterative factorial : " + factorialIterative(5));
        System.out.println("recursive factorial : " + factorialRecursive(5));
    }
}
