package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

import mylib.MyLibs;

/*
 * 문제 : 카카오프렌즈 컬리링북 url : url :
 * https://programmers.co.kr/learn/courses/30/lessons/1829 
 * 유형 : 2017 카카오코드 예선
 */

public class ColoringBook {
    public static void main(String[] args) {
        int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
                { 0, 0, 0, 3 } };
        System.out.println("4\t5");
        MyLibs.pList(solution(6, 4, picture));
    }

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
    }

    static int size = 1;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        boolean[][] check = new boolean[m][n];
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] > 0 && !check[i][j]) {
                    size = 1;
                    bfs(j, i, m, n, picture, check, q);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                    numberOfArea++;
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void bfs(int x, int y, int m, int n, int[][] picture, boolean[][] check, Queue<Node> q) {
        q.offer(new Node(x, y));
        check[y][x] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.getX() + dx[i];
                int ny = node.getY() + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !check[ny][nx] && picture[y][x] == picture[ny][nx]) {
                    size++;
                    check[ny][nx] = true;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }
}
