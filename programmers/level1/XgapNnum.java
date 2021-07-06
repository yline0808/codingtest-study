package programmers.level1;

import mylib.MyLibs;

/*
 * 문제 : x만큼 간격이 있는 n개의 숫자
 * url : https://programmers.co.kr/learn/courses/30/lessons/12954
 * 유형 : 연습문제
 */

public class XgapNnum {
    public static void main(String[] args) {
        System.out.println("2\t4\t6\t8\t10");
        MyLibs.pList(solution(2, 5));
    }

    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + x;
        }

        return answer;
    }
}
