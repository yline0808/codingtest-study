package programmers.level1;

import java.util.Arrays;

/*
 * 문제 : 정수 내림차순으로 배치하기
 * url : https://programmers.co.kr/learn/courses/30/lessons/12933
 * 유형 : 연습문제
 */

public class NumberSort {
    public static void main(String[] args) {
        System.out.println(873211);
        System.out.println(solution(118372));
    }

    public static long solution(long n) {
        char[] arr = Long.toString(n).toCharArray();
        Arrays.sort(arr);
        return Long.parseLong(new StringBuffer(new String(arr)).reverse().toString());
    }
}
