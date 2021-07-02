package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

import mylib.MyLibs;

/*
 * 제목 : 게임 맵 최단거리
 * url : https://programmers.co.kr/learn/courses/30/lessons/1844
 * 유형 : 찾아라 프로그래밍 마에스터
 * 
 * bfs
 */

class GameNode {
    private int x;
    private int y;

    public GameNode(int x, int y) {
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

public class GameMapSortCut {
    public static void main(String[] args) {
        int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 } };
        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        // 북 동 남 서
        int[] dy = { -1, 0, 1, 0 };
        int[] dx = { 0, 1, 0, -1 };
        Queue<GameNode> q = new LinkedList<>();
        int x = 0;
        int y = 0;
        int answer = 0;

        q.offer(new GameNode(x, y));
        while (!q.isEmpty()) {
            GameNode node = q.poll();
            x = node.getX();
            y = node.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= maps[0].length || ny >= maps.length || maps[ny][nx] == 0)
                    continue;
                if (maps[ny][nx] == 1) {
                    maps[ny][nx] = maps[y][x] + 1;
                    q.offer(new GameNode(nx, ny));
                }
            }
        }
        answer = maps[maps.length - 1][maps[0].length - 1];
        MyLibs.pList(maps);
        return answer == 1 ? -1 : answer;
    }
}
