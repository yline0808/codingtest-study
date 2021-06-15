package programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * 문제 : 프린터
 * url : https://programmers.co.kr/learn/courses/30/lessons/42587
 * 유형 : 스택/큐
 */

class PrintItem {
    private int location;
    private int priority;

    PrintItem(int location, int priority) {
        this.location = location;
        this.priority = priority;
    }

    public int getLocation() {
        return this.location;
    }

    public int getPriority() {
        return this.priority;
    }
}

public class Printer {
    public static void main(String[] args) {
        int[] priorities = { 2, 1, 3, 2 };
        System.out.println(solution(priorities, 2));
        int[] priorities2 = { 1, 1, 9, 1, 1, 1 };
        System.out.println(solution(priorities2, 0));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int priority : priorities)
            pq.offer(priority);

        for (int test : pq) {
            System.out.println(test);
        }

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
