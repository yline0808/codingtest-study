package programmers.level1;

import mylib.MyLibs;

/*
 * 문제 : 로또의 최고 순위와 최저 순위
 * url : https://programmers.co.kr/learn/courses/30/lessons/77484
 * 유형 : 2021 Dev-Matching: 웹 백엔드 개발자 (상반기)
 */

public class Lotto {
    public static void main(String[] args) {
        int[] lottos = { 44, 1, 0, 0, 31, 25 };
        int[] winNums = { 31, 10, 45, 1, 6, 19 };
        MyLibs.pList(new int[] { 3, 5 });
        MyLibs.pList(solution(lottos, winNums));
    }

    public static int[] solution(int[] lottos, int[] winNums) {
        int zero = 0;
        int match = 0;
        for (int myNum : lottos) {
            if (myNum == 0)
                zero++;
            else {
                for (int winNum : winNums) {
                    if (myNum == winNum) {
                        match++;
                        break;
                    }
                }
            }
        }
        int max = zero + match;
        int min = match;
        int[] answer = { Math.min(7 - max, 6), Math.min(7 - min, 6) };
        return answer;
    }
}
