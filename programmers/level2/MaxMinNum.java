package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;

/*
 * 문제 : 최댓값과 최솟값
 * url : https://programmers.co.kr/learn/courses/30/lessons/12939
 * 유형 : 연습문제
 */

public class MaxMinNum {
    public static void main(String[] args) {
        System.out.println("-4 -1");
        System.out.println(solution("-1 -2 -3 -4"));
    }

    public static String solution(String s) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (String num : s.split(" "))
            arr.add(Integer.parseInt(num));

        Collections.sort(arr);
        return arr.get(0) + " " + arr.get(arr.size() - 1);
    }
}
