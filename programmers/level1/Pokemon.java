package programmers.level1;

import java.util.HashSet;

/*
 * 문제 : 포켓몬
 * url : https://programmers.co.kr/learn/courses/30/lessons/1845
 * 유형 : 찾아라 프로그래밍 마에스터
 */

public class Pokemon {
    public static void main(String[] args) {
        int[] nums = { 3, 3, 3, 2, 2, 4 };
        System.out.println(3);
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        for (int loop : nums) {
            set.add(loop);
        }
        return answer > set.size() ? set.size() : answer;
    }
}
