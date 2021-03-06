package chapter09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 문제를 잘 읽어야 합니다ㅏ.
 * 최대한 많은 도시이기 때문에 다익스트라 알고리즘 사용
 */

public class Test03_message {
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
            return "[" + index + "]" + distance + " ";
        }

        @Override
        public int compareTo(Node other) {
            if (this.distance < other.distance)
                return -1;
            return 1;
        }
    }

    public static final int INF = (int) 1e9;
    public static int n, m, start;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static int[] d = new int[30001];
    // public static int[][] arr = { { 1, 2, 4 }, { 1, 3, 2 } };
    public static int[][] arr = { { 1, 2, 2 }, { 1, 3, 5 }, { 1, 4, 1 }, { 2, 3, 3 }, { 2, 4, 2 }, { 3, 2, 3 },
            { 3, 6, 5 }, { 4, 3, 3 }, { 4, 5, 1 }, { 5, 3, 1 }, { 5, 6, 2 } };

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();

            if (d[now] < dist)
                continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        // n = 3;
        // m = 2;
        n = 6;
        m = 11;
        start = 1;

        Arrays.fill(d, INF);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }
        for (int i = 0; i < m; i++) {
            graph.get(arr[i][0]).add(new Node(arr[i][1], arr[i][2]));
        }

        dijkstra(start);

        int count = 0;
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            if (d[i] != INF) {
                count++;
                maxDistance = Math.max(maxDistance, d[i]);
            }
        }

        System.out.printf("%d, %d ", (count - 1), maxDistance);
    }
}
