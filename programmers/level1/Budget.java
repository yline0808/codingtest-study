package programmers.level1;

import java.util.Arrays;

/*
 * 문제 : 예산 
 * url : https://programmers.co.kr/learn/courses/30/lessons/12982
 * 유형 : Summer/Winter Coding(~2018)
 */

public class Budget {
    public static void main(String[] args) {
        int[] d = { 1, 3, 2, 5, 4 };
        System.out.println(3);
        System.out.println(solution(d, 9));
    }

    public static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int sum = 0;
        for (int n : d) {
            sum += n;
            if (sum > budget)
                break;
            answer++;
        }

        return answer;
    }
}
