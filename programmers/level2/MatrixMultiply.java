package programmers.level2;

import mylib.MyLibs;

/*
 * 제목 : 행렬의 곱샘
 * url : https://programmers.co.kr/learn/courses/30/lessons/12949
 * 유형 : 연습문제
 */

public class MatrixMultiply {
    public static void main(String[] args) {
        int[][] arr1 = { { 2, 3, 2 }, { 4, 2, 4 }, { 3, 1, 4 } };
        int[][] arr2 = { { 5, 4, 3 }, { 2, 4, 1 }, { 3, 1, 1 } };
        MyLibs.pList(solution(arr1, arr2));
        System.out.println();
        int[][] arr3 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
        int[][] arr4 = { { 3, 3 }, { 3, 3 } };
        MyLibs.pList(solution(arr3, arr4));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                for (int k = 0; k < arr2[0].length; k++) {
                    answer[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }

        return answer;
    }
}
