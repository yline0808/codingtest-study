package programmers.level2;

import mylib.MyLibs;

/*
 * 문제 : 이진 변환 반복하기
 * url : https://programmers.co.kr/learn/courses/30/lessons/70129
 * 유형 : 월간 코드 챌린지 시즌1
 */

public class BinaryTransformation {
    public static int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1')
                    cnt++;
            }
            answer[0]++;
            answer[1] += s.length() - cnt;
            s = Integer.toBinaryString(cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("3\t8");
        MyLibs.pList(solution("110010101001"));
        System.out.println("3\t3");
        MyLibs.pList(solution("01110"));
        System.out.println("4\t1");
        MyLibs.pList(solution("1111111"));
    }
}