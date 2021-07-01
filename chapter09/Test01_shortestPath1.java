package chapter09;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 다익스트라 구현 방법
 * 1번 문제는 구현은 간단하지만 시간복잡도가 별로임
 */

public class Test01_shortestPath1 {
    static class Node {
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
    }

    // 임시로 무한 표시
    public static final int INF = (int) 1e9;
    // 순서대로 노드 수, 간선의 수, 시작 노드
    public static int n, m, start;
    // 그래프
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    // 방문여부 체크
    public static boolean[] visited = new boolean[100001];
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

    public static int getSmallesNode() {
        int min_value = INF;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (d[i] < min_value && !visited[i]) {
                min_value = d[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int start) {
        d[start] = 0;
        visited[start] = true;
        for (int i = 0; i < graph.get(start).size(); i++) {
            d[graph.get(start).get(i).getIndex()] = graph.get(start).get(i).getDistance();
        }

        for (int i = 0; i < n - 1; i++) {
            int now = getSmallesNode();
            visited[now] = true;

            for (int j = 0; j < graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).getDistance();

                if (cost < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }

    // ===방법2===
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
