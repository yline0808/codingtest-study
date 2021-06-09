package chapter09;

import java.util.Arrays;

/*
 * 플로이드를 사용
 */

public class Test02_city {
    public static final int INF = (int) 1e9;
    public static int n = 5;
    public static int m = 7;
    public static int x = 4;
    public static int k = 5;
    public static int[][] graph = new int[101][101];
    public static int[][] arr = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 4 }, { 3, 4 }, { 3, 5 }, { 4, 5 } };

    public static void main(String[] args) {
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    graph[i][j] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            graph[arr[i][0]][arr[i][1]] = 1;
            graph[arr[i][1]][arr[i][0]] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.printf("%s\t", graph[i][j] == INF ? "INF" : ("" + graph[i][j]));
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.printf("%s\t", graph[i][j] == INF ? "INF" : ("" + graph[i][j]));
            }
            System.out.println();
        }
        System.out.println();

        int distance = graph[1][k] + graph[k][x];

        System.out.println(distance >= INF ? -1 : distance);
    }
}
