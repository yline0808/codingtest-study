package programmers.level2;

import mylib.MyLibs;

/*
 * 문제 : 주시가격
 * url : https://programmers.co.kr/learn/courses/30/lessons/42584
 * 유형 : 스택/큐
 */

public class Stock {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 2, 3 };
        System.out.println("4\t3\t1\t1\t0");
        MyLibs.pList(solution(prices));
    }
}
