package programmers.level2;

import java.util.Arrays;

/*
 * 제목 : 최솟값 만들기
 * url : https://programmers.co.kr/learn/courses/30/lessons/12941
 * 유형 : 연습문제
 */

public class MinNumber {
    public static void main(String[] args) {
        int[] a1 = { 1, 4, 2 };
        int[] b1 = { 5, 4, 4 };
        System.out.println(29);
        System.out.println(solution(a1, b1));

        int[] a2 = { 1, 2 };
        int[] b2 = { 3, 4 };
        System.out.println(10);
        System.out.println(solution(a2, b2));
    }

    public static int solution(int[] a, int[] b) {
        int answer = 0;

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++)
            answer += a[i] * b[b.length - 1 - i];

        return answer;
    }
}
