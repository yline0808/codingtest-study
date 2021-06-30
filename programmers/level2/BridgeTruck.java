package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 문제 : 다리를 지나는 트럭
 * url : https://programmers.co.kr/learn/courses/30/lessons/42583
 * 유형 : 스택/큐
 */

public class BridgeTruck {
    public static void main(String[] args) {
        int[] truck_weights1 = { 7, 4, 5, 6 };
        int[] truck_weights2 = { 10 };
        int[] truck_weights3 = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };

        System.out.println(8);
        System.out.println(solution(2, 10, truck_weights1));
        System.out.println(101);
        System.out.println(solution(100, 100, truck_weights2));
        System.out.println(110);
        System.out.println(solution(100, 100, truck_weights3));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int answer = bridge_length;
        int max = 0;

        for (int w : truck_weights) {
            while (true) {
                if (q.isEmpty()) {
                    q.offer(w);
                    answer++;
                    max += w;
                    break;
                } else if (q.size() == bridge_length) {
                    max -= q.poll();
                } else {
                    if (max + w > weight) {
                        q.offer(0);
                        answer++;
                    } else {
                        q.offer(w);
                        max += w;
                        answer++;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}
