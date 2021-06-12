package programmers.level1;

/*
 * 제목 : 내적
 * url : https://programmers.co.kr/learn/courses/30/lessons/70128
 * 유형 : 월간 코드 챌린지 시즌1
 */

public class DotProduct {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4 };
        int[] b = { -3, -1, 0, 2 };
        System.out.println(solution(a, b));
    }

    public static int solution(int[] a, int[] b) {
        int answer = 0;

        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }

        return answer;
    }
}
