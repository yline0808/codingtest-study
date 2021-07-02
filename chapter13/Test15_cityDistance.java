package chapter13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import mylib.MyLibs;

/*
 * 도시 개수 : N
 * 도로 개수 : M
 * 거리 정보 : K
 * 출발 도시 : X
 */

public class Test15_cityDistance {

    public static int[] solution(int n, int m, int k, int x, int[][] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] citys = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            citys[i] = -1;
        }

        for (int i = 0; i < m; i++)
            graph.get(arr[i][0]).add(arr[i][1]);

        citys[x] = 0;
        q.offer(x);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                int nextNode = graph.get(now).get(i);
                if (citys[nextNode] == -1) {
                    citys[nextNode] = citys[now] + 1;
                    q.offer(nextNode);
                }
            }
        }

        for (int i = 0; i < citys.length; i++)
            if (citys[i] == k)
                answer.add(i);

        if (answer.isEmpty())
            answer.add(-1);

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 } };
        System.out.println(4);
        MyLibs.pList(solution(4, 4, 2, 1, arr));
    }
}