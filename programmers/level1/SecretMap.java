package programmers.level1;

import mylib.MyLibs;

/*
 * 문제 : [1차] 비밀지도
 * url : https://programmers.co.kr/learn/courses/30/lessons/17681
 * 유형 : 2018 KAKAO BLIND RECRUITMENT
 */

public class SecretMap {
    public static void main(String[] args) {
        int[] arr1 = { 9, 20, 28, 18, 11 };
        int[] arr2 = { 30, 1, 21, 17, 28 };
        String[] answer1 = { "#####", "# # #", "### #", "#  ##", "#####" };
        int[] arr3 = { 46, 33, 33, 22, 31, 50 };
        int[] arr4 = { 27, 56, 19, 14, 14, 10 };
        String[] answer2 = { "######", "### #", "## ##", " #### ", " #####", "### # " };
        // MyLibs.pList(answer1);
        // MyLibs.pList(solution(5, arr1, arr2));
        // MyLibs.pList(answer2);
        // MyLibs.pList(solution(6, arr3, arr4));
        bin(arr3);
        System.out.println();
        bin(arr4);
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String tmp = Integer.toBinaryString(Integer.parseInt(Integer.toBinaryString(arr1[i]), 2)
                    | Integer.parseInt(Integer.toBinaryString(arr2[i]), 2));
            System.out.println(tmp);

            answer[i] = "";
            for (char c : tmp.toCharArray())
                answer[i] += c == '1' ? '#' : ' ';
        }
        return answer;
    }

    public static void bin(int[] arr) {
        for (int n : arr)
            System.out.println(n + "|" + Integer.toBinaryString(n));
    }
}
