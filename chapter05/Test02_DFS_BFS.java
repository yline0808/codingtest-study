package chapter05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test02_DFS_BFS {
    static class Node {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public void show() {
            System.out.printf("(%d, %d) ", this.index, this.distance);
        }
    }

    public static void adjacencyMatrix() {
        final int INF = 999999999;
        int[][] graph = { { 0, 7, 5 }, { 7, 0, INF }, { 5, INF, 0 } };

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void adjacencyList() {
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

        for (int i = 0; i < 3; i++) {
            graph.add(new ArrayList<Node>());
        }

        graph.get(0).add(new Node(1, 7));
        graph.get(0).add(new Node(2, 5));
        graph.get(1).add(new Node(0, 7));
        graph.get(2).add(new Node(0, 5));

        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                graph.get(i).get(j).show();
            }
            System.out.println();
        }
    }

    public static void dfsEx() {
        boolean[] visited = new boolean[9];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }

        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        graph.get(2).add(1);
        graph.get(2).add(7);

        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        graph.get(4).add(3);
        graph.get(4).add(5);

        graph.get(5).add(3);
        graph.get(5).add(4);

        graph.get(6).add(7);

        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        graph.get(8).add(1);
        graph.get(8).add(7);

        dfs(graph, 1, visited);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, int idx, boolean[] visited) {
        visited[idx] = true;
        System.out.printf("%d ", idx);

        for (int i = 0; i < graph.get(idx).size(); i++) {
            int nextIdx = graph.get(idx).get(i);
            if (!visited[nextIdx])
                dfs(graph, nextIdx, visited);
        }
    }

    public static void bfs(ArrayList<ArrayList<Integer>> graph, int idx, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        visited[idx] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.printf("%d ", x);

            for (int i = 0; i < graph.get(x).size(); i++) {
                int nextIdx = graph.get(x).get(i);
                if (!visited[nextIdx]) {
                    q.offer(nextIdx);
                    visited[nextIdx] = true;
                }
            }
        }
    }

    public static void bfsEx() {
        boolean[] visited = new boolean[9];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }

        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        graph.get(2).add(1);
        graph.get(2).add(7);

        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        graph.get(4).add(3);
        graph.get(4).add(5);

        graph.get(5).add(3);
        graph.get(5).add(4);

        graph.get(6).add(7);

        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        graph.get(8).add(1);
        graph.get(8).add(7);

        bfs(graph, 1, visited);
    }

    public static void main(String[] args) {
        System.out.println("======matrix=======");
        adjacencyMatrix();
        System.out.println("======list=======");
        adjacencyList();
        System.out.println("======DFS=======");
        dfsEx();
        System.out.println("\n======BFS=======");
        bfsEx();
    }
}
