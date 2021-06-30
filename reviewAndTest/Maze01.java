package reviewAndTest;

import java.util.LinkedList;
import java.util.Queue;

public class Maze01 {
    static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
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
            return "[" + this.x + ", " + this.y + "] ";
        }
    }

    public static int[][] map = { { 1, 0, 1, 0, 1, 0 }, { 1, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 1 },
            { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 } };
    public static int n = 5, m = 6;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, 1, -1 };

    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.getX() + dx[i];
                int ny = node.getY() + dy[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n || map[ny][nx] == 0)
                    continue;
                if (map[ny][nx] == 1) {
                    map[ny][nx] = map[node.getY()][node.getX()] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }

        return map[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.out.println(10);
        System.out.println(bfs(0, 0));
    }
}
