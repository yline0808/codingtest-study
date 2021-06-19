package programmers.level2;

/*
 * 제목 : 피보나치 수
 * url : https://programmers.co.kr/learn/courses/30/lessons/12945
 * 유형 : 연습문제
 */

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(2);
        System.out.println(solution(3));
        System.out.println(5);
        System.out.println(solution(5));
    }

    public static int solution(int n) {
        if (n <= 2)
            return 1;

        int answer = 0, num1 = 1, num2 = 1;

        for (int i = 3; i <= n; i++) {
            answer = (num1 + num2) % 1234567;
            num1 = num2;
            num2 = answer;
        }
        return answer;
    }
}
