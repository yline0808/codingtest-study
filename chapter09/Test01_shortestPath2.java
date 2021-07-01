package chapter09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 다익스트라는 이 문제를 외울것
 * 개선된 다익스트라 알고리즘은 힙 자료구저를 사용
 * O(N^2) vs O(log2 N) 비교해보면 두번째 방법이 획기적임을 알 수 있음
 * 현재 가장 가꾸운 노드를 저장하기 위한 목적으로만 우선순위 큐를 추가로 이용
 */

public class Test01_shortestPath2 {
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
            return "[" + index + "]:" + distance + " ";
        }

        @Override
        public int compareTo(Node other) {
            if (this.distance < other.distance)
                return -1;
            return 1;
        }
    }

    // 임시로 무한 표시
    public static final int INF = (int) 1e9;
    // 순서대로 노드 수, 간선의 수, 시작 노드
    public static int n, m, start;
    // 그래프
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    // 최단 거리 저장
    public static int[] d = new int[100001];

    public static void initGraph() {
        int[][] arr = { { 1, 2, 2 }, { 1, 3, 5 }, { 1, 4, 1 }, { 2, 3, 3 }, { 2, 4, 2 }, { 3, 2, 3 }, { 3, 6, 5 },
                { 4, 3, 3 }, { 4, 5, 1 }, { 5, 3, 1 }, { 5, 6, 2 } };

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < m; i++) {
            graph.get(arr[i][0]).add(new Node(arr[i][1], arr[i][2]));
        }

        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print("[" + i + "]=>" + graph.get(i).get(j).toString());
            }
            System.out.println();
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();

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
        n = 6;
        m = 11;
        start = 1;

        initGraph();
        Arrays.fill(d, INF);

        dijkstra(start);

        for (int i = 1; i <= n; i++) {
            System.out.println(d[i] == INF ? "INFINITY" : d[i]);
        }
    }
}