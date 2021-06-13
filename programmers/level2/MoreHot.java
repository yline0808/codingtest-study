package programmers.level2;

import java.util.PriorityQueue;

/*
 * 문제 : 더 맵게
 * url : https://programmers.co.kr/learn/courses/30/lessons/42626
 * 유형 : 힙
 */

public class MoreHot {
    public static void main(String[] args) {
        int[] scoville = { 1, 2, 3, 9, 10, 12 };
        System.out.println(solution(scoville, 7));
    }

    public static int solution(int[] scoville, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int scov : scoville) {
            pq.offer(scov);
        }
        while (pq.peek() < k) {
            if (pq.size() == 1)
                return -1;
            pq.offer(pq.poll() + pq.poll() * 2);
            answer++;
        }

        return answer;
    }
}
