package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 제목 : 가장 큰 수
 * url : https://programmers.co.kr/learn/courses/30/lessons/42746
 * 유형 : 정렬
 * 
 * copareTo() 참고 url
 * 참고 : https://mine-it-record.tistory.com/133
 */

public class BigNumber {
    public static void main(String[] args) {
        int[] numbers = { 3, 30, 34, 5, 9 };
        System.out.println(9534330);
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });
        for (String num : arr)
            answer += num;

        return answer.charAt(0) == '0' ? "0" : answer;
    }
}
