package programmers.level2;

import mylib.MyLibs;

/*
 * 문제 : 124 나라의 숫자
 * url : https://programmers.co.kr/learn/courses/30/lessons/12899
 * 유형 : 연습문제
 */

public class Num124 {
    public static void main(String[] args) {
        long startTime, endTime;
        String result;
        int n = 50000000;

        startTime = System.currentTimeMillis();
        result = solution(n);
        endTime = System.currentTimeMillis();
        MyLibs.pResult(startTime, endTime, result);
    }

    public static String solution(int n) {
        String[] num = { "4", "1", "2" };
        String answer = "";

        while (n > 0) {
            answer = num[n % 3] + answer;
            n = (n - 1) / 3;
        }

        return answer;
    }
}
