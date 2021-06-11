package reviewAndTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class NodeCity implements Comparable<NodeCity> {
    private int index;
    private int distance;

    public NodeCity(int index, int distance) {
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
    public int compareTo(NodeCity other) {
        if (this.distance < other.distance)
            return -1;
        return 1;
    }
}

public class Message {
    public static final int INF = (int) 1e9;
    public static int n, m, start;
    public static ArrayList<ArrayList<NodeCity>> graph = new ArrayList<ArrayList<NodeCity>>();
    public static int[] d = new int[30001];
    public static int[][] arr = { { 1, 2, 4 }, { 1, 3, 2 } };

    public static void dijkstra(int start) {
        PriorityQueue<NodeCity> pq = new PriorityQueue<>();
        pq.offer(new NodeCity(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            NodeCity node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();

            if (d[now] < dist)
                continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new NodeCity(graph.get(now).get(i).getIndex(), cost));
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
            graph.add(new ArrayList<NodeCity>());
        }
        for (int i = 0; i < m; i++) {
            graph.get(arr[i][0]).add(new NodeCity(arr[i][1], arr[i][2]));
        }

        dijkstra(start);

        int cnt = 0;
        int maxDistance = 0;

        for (int i = 1; i <= n; i++) {
            if (d[i] != INF) {
                cnt++;
                maxDistance = Math.max(d[i], maxDistance);
            }
        }
        System.out.println((cnt - 1) + ", " + maxDistance);
    }
}
