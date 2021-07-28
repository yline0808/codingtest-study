package programmers.level2;

import java.util.HashMap;

/*
 * 문제 : 위장
 * url : https://programmers.co.kr/learn/courses/30/lessons/42578
 * 유형 : 해시
 */

public class Camouflage {
    public static void main(String[] args) {
        String[][] clothes1 = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
                { "green_turban", "headgear" } };
        String[][] clothes2 = { { "crowmask", "face" }, { "bluesunglasses", "face" }, { "smoky_makeup", "face" } };
        System.out.println(5);
        System.out.println(solution(clothes1));
        System.out.println(3);
        System.out.println(solution(clothes2));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();

        for (String[] cloth : clothes)
            hm.put(cloth[1], hm.getOrDefault(cloth[1], 1) + 1);

        for (int val : hm.values())
            answer *= val;

        return --answer;
    }
}
