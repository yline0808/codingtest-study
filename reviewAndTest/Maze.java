package reviewAndTest;

import java.util.LinkedList;
import java.util.Queue;

import mylib.MyLibs;

class Node05 {
    private int x;
    private int y;

    public Node05(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String toString() {
        return "";
    }
}

public class Maze {
    public static int[][] map = { { 1, 0, 1, 0, 1, 0 }, { 1, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 1 },
            { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 } };
    public static int n = 5, m = 6;
    // 상 하 좌 우
    public static int[] dx = { 0, 0, -1, 1 };
    public static int[] dy = { -1, 1, 0, 0 };

    public static int bfs(int x, int y) {
        Queue<Node05> q = new LinkedList<>();
        q.offer(new Node05(x, y));

        while (!q.isEmpty()) {
            Node05 node = q.poll();
            x = node.getX();
            y = node.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n)
                    continue;
                if (map[ny][nx] == 0)
                    continue;
                if (map[ny][nx] == 1) {
                    map[ny][nx] = map[y][x] + 1;
                    q.offer(new Node05(nx, ny));
                }
            }
        }
        return map[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int result = 0;

        long startTime = System.currentTimeMillis();

        result = bfs(0, 0);

        long endTime = System.currentTimeMillis();

        MyLibs.pResult(startTime, endTime, result);
    }
}
