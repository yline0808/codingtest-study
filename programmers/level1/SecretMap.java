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
        String[] answer2 = { "######", "###  #", "##  ##", " #### ", " #####", "### # " };

        int[] arr5 = { 0, 0, 0, 0, 0 };
        int[] arr6 = { 30, 1, 21, 17, 28 };
        String[] answer3 = { "#### ", "    #", "# # #", "#   #", "###  " };

        MyLibs.pList(answer1);
        MyLibs.pList(solution(5, arr1, arr2));
        MyLibs.pList(answer2);
        MyLibs.pList(solution(6, arr3, arr4));
        MyLibs.pList(answer3);
        MyLibs.pList(solution(5, arr5, arr6));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++)
            answer[i] = String.format("%" + n + "s", Integer.toBinaryString(arr1[i] | arr2[i])).replace("1", "#")
                    .replace("0", " ");
        return answer;
    }
}
