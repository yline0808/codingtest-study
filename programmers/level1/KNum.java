package programmers.level1;

import java.util.Arrays;

import mylib.MyLibs;

/*
 * 문제 : K번째수
 * url : https://programmers.co.kr/learn/courses/30/lessons/42748?language=java
 * 유형 : 정렬
 */

public class KNum {
    public static void main(String[] args) {
        int[] array = { 1, 5, 2, 6, 3, 7, 4 };
        int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
        MyLibs.pList(solution(array, commands));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] tmp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2] - 1];
        }

        return answer;
    }
}
