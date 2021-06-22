package programmers.level2;

import java.util.Stack;

/*
 * 문제 : 올바른 괄호
 * url : https://programmers.co.kr/learn/courses/30/lessons/12909
 * 유형 : 연습문제
 */

public class FitBracket {
    public static void main(String[] args) {
        String[] s = { "()()", "(())()", ")()(", "(()(" };
        boolean[] result = { true, true, false, false };
        for (int i = 0; i < s.length; i++) {
            System.out.println(result[i]);
            System.out.println(solution(s[i]));
            System.out.println();
        }
    }

    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() != s.charAt(i) && s.charAt(i) == ')')
                stack.pop();
            else
                stack.add(s.charAt(i));
        }
        System.out.println(stack.toString());

        return stack.isEmpty();
    }
}
