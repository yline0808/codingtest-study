package programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * 문제 : 프린터
 * url : https://programmers.co.kr/learn/courses/30/lessons/42587
 * 유형 : 스택/큐
 */

public class Printer {
    public static void main(String[] args) {
        int[] priorities = { 2, 1, 3, 2 };
        System.out.println(solution(priorities, 2));
        int[] priorities2 = { 1, 1, 9, 1, 1, 1 };
        System.out.println(solution(priorities2, 0));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int priority : priorities)
            pq.offer(priority);

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;
                    if (location == i) {
                        pq.clear();
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
