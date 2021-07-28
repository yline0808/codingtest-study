package programmers.level2;

import java.util.Stack;

/*
 * 문제 : 괄호 회전하기
 * url : https://programmers.co.kr/learn/courses/30/lessons/76502
 * 유형 : 월간 코드 챌린지 시즌2
 */

public class BracketRotation {
    public static void main(String[] args) {
        System.out.println(3);
        System.out.println(solution("[](){}"));
    }

    public static int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isTrue(s.substring(i, s.length()) + s.substring(0, i)))
                answer++;
        }

        return answer;
    }

    public static boolean isTrue(String s) {
        Stack<Character> stack = new Stack<>();
        char[] openBracket = { '(', '{', '[' };
        char[] closeBracket = { ')', '}', ']' };
        boolean flag = false;

        for (int i = 0; i < 3; i++)
            if (s.charAt(0) == closeBracket[i])
                return false;
        for (int i = 0; i < s.length(); i++) {
            flag = false;
            for (int j = 0; j < 3; j++) {
                if (!stack.isEmpty() && stack.peek() == openBracket[j] && s.charAt(i) == closeBracket[j])
                    flag = true;
            }
            if (flag)
                stack.pop();
            else
                stack.add(s.charAt(i));
        }
        return stack.isEmpty();
    }
}
