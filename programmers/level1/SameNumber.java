package programmers.level1;

import java.util.ArrayList;

/*
 * 문제 : 같은 숫자는 싫어
 * url : https://programmers.co.kr/learn/courses/30/lessons/12906
 * 유형 : 연습문제
 */

public class SameNumber {
    public static void main(String[] args) {
        int[] arr1 = { 1, 1, 3, 3, 0, 1, 1 };
        int[] arr2 = { 4, 4, 4, 3, 3 };
        System.out.println("1\t3\t0\t1");
        System.out.println(solution(arr1));
        System.out.println("4\t3");
        System.out.println(solution(arr2));
    }

    public static int[] solution(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(arr[0]);
        for (int i = 1; i < arr.length; i++)
            if (arr[i - 1] != arr[i])
                result.add(arr[i]);

        return result.stream().mapToInt(i -> i).toArray();
    }
}
