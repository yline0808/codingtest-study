package programmers.level2;

/*
 * 문제 : 숫자의 표현
 * url : https://programmers.co.kr/learn/courses/30/lessons/12924
 * 유형 : 연습문제
 */

public class NumExpression {
    public static void main(String[] args) {
        System.out.println(4);
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        int answer = 1;

        for (int i = 1; i <= n / 2; i++) {
            int sum = 0;
            int j = i;
            while (sum < n)
                sum += j++;
            if (sum == n)
                answer++;
        }

        return answer;
    }
}
