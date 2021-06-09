package chapter09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 문제를 잘 읽어야 합니다ㅏ.
 * 최대한 많은 도시이기 때문에 다익스트라 알고리즘 사용
 */

class Node03 implements Comparable<Node03> {
    private int index;
    private int distance;

    public Node03(int index, int distance) {
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
    public int compareTo(Node03 other) {
        if (this.distance < other.distance)
            return -1;
        return 1;
    }
}

public class Test03_message {
    public static final int INF = (int) 1e9;
    public static int n, m, start;
    public static ArrayList<ArrayList<Node03>> graph = new ArrayList<ArrayList<Node03>>();
    public static int[] d = new int[30001];
    public static int[][] arr = { { 1, 2, 4 }, { 1, 3, 2 } };

    public static void dijkstra(int start) {
        PriorityQueue<Node03> pq = new PriorityQueue<>();
        pq.offer(new Node03(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node03 node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();

            if (d[now] < dist)
                continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node03(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        n = 3;
        m = 2;
        start = 1;

        Arrays.fill(d, INF);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node03>());
        }
        for (int i = 0; i < m; i++) {
            graph.get(arr[i][0]).add(new Node03(arr[i][1], arr[i][2]));
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
