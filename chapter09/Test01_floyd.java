package chapter09;

import java.util.Arrays;

public class Test01_floyd {
    public static final int INF = (int) 1e9;

    public static int n, m;

    public static int[][] graph = new int[501][501];

    public static int[][] arr = { { 1, 2, 4 }, { 1, 4, 6 }, { 2, 1, 3 }, { 2, 3, 7 }, { 3, 1, 5 }, { 3, 4, 4 },
            { 4, 3, 2 } };

    public static void main(String[] args) {
        n = 4;
        m = 7;

        for (int i = 0; i < 501; i++) {
            Arrays.fill(graph[i], INF);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    graph[i][j] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            graph[arr[i][0]][arr[i][1]] = arr[i][2];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print((graph[i][j] == INF ? "INF" : graph[i][j]) + "\t");
            }
            System.out.println();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }
        System.out.println();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print((graph[i][j] == INF ? "INFINITY" : graph[i][j]) + "\t");
            }
            System.out.println();
        }
    }
}
