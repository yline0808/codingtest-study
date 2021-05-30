package chapter05;

import java.util.LinkedList;
import java.util.Queue;

import mylib.MyLibs;

/*
 * n x m 크기 미로에서 사작 : 1, 1 출구 : n, m
 * 1이 적힌 칸으로만 이동하는 최소 칸의 갯수를 구하시오
 */

class Node04 {
    private int x;
    private int y;

    public Node04(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class Test04_maze {
    public static int[][] map = { { 1, 0, 1, 0, 1, 0 }, { 1, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 1 },
            { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 } };
    public static int n = 5, m = 6;
    // 상 하 좌 우
    public static int[] dx = { 0, 0, -1, 1 };
    public static int[] dy = { -1, 1, 0, 0 };

    public static int bfs(int x, int y) {
        Queue<Node04> q = new LinkedList<>();
        q.offer(new Node04(x, y));

        while (!q.isEmpty()) {
            Node04 node = q.poll();
            x = node.getX();
            y = node.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                    continue;
                if (map[ny][nx] == 0)
                    continue;
                if (map[ny][nx] == 1 && ny != 0 && nx != 0) {
                    map[ny][nx] = map[y][x] + 1;
                    q.offer(new Node04(nx, ny));
                }
            }
        }

        return map[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int result = 0;
        MyLibs.pList(map);
        System.out.println();
        long startTime = System.currentTimeMillis();

        result = bfs(0, 0);

        long endTime = System.currentTimeMillis();
        MyLibs.pList(map);
        MyLibs.pResult(startTime, endTime, result);
    }
}
