package programmers.level2;

import java.util.Arrays;
import java.util.PriorityQueue;

import mylib.MyLibs;

/*
 * 문제 : 배달
 * url : https://programmers.co.kr/learn/courses/30/lessons/12978
 * 유형 : Summer/Winter Coding(~2018)
 */

public class Delivery {
    static class Node implements Comparable<Node> {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return this.index;
        }

        public int getDistance() {
            return this.distance;
        }

        public String toString() {
            return "[" + this.index + "]:" + this.distance + " ";
        }

        @Override
        public int compareTo(Node other) {
            return this.distance < other.distance ? -1 : 1;
        }
    }

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] town = new int[N + 1];

        Arrays.fill(town, 500001);
        town[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();

            if (dist > town[now])
                continue;

            for (int i = 0; i < road.length; i++) {
                int cost, idx;
                if (road[i][0] == now) {
                    cost = road[i][2] + dist;
                    idx = road[i][1];
                    if (cost < town[idx]) {
                        town[idx] = cost;
                        pq.add(new Node(idx, cost));
                    }
                } else if (road[i][1] == now) {
                    cost = road[i][2] + dist;
                    idx = road[i][0];
                    if (cost < town[idx]) {
                        town[idx] = cost;
                        pq.add(new Node(idx, cost));
                    }
                }
            }
        }
        MyLibs.pList(town);
        for (int i = 0; i < town.length; i++) {
            answer += town[i] <= K ? 1 : 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] road1 = { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1 }, { 5, 4, 2 } };
        int[][] road2 = { { 1, 2, 1 }, { 1, 3, 2 }, { 2, 3, 2 }, { 3, 4, 3 }, { 3, 5, 2 }, { 3, 5, 3 }, { 5, 6, 1 } };
        System.out.println(4);
        System.out.println(solution(5, road1, 3));
        System.out.println(4);
        System.out.println(solution(6, road2, 4));
    }
}
