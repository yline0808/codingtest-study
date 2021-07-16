package programmers.level2;

import mylib.MyLibs;

/*
 * 문제 : [3차] 압축
 * url : https://programmers.co.kr/learn/courses/30/lessons/17684
 * 유형 : 2018 KAKAO BLIND RECRUITMENT
 */

public class Zip {
    public static void main(String[] args) {
        int[] result1 = { 11, 1, 27, 15 };
        int[] result2 = { 20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34 };
        int[] result3 = { 1, 2, 27, 29, 28, 31, 30 };

        MyLibs.pList(result1);
        MyLibs.pList(solution("KAKAO"));
        MyLibs.pList(result2);
        MyLibs.pList(solution("TOBEORNOTTOBEORTOBEORNOT"));
        MyLibs.pList(result3);
        MyLibs.pList(solution("ABABABABABABABAB"));
    }

    public static int[] solution(String msg) {
        int[] answer = new int[msg.length()];

        return answer;
    }
}
