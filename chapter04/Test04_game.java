package chapter04;

import java.util.Scanner;

import mylib.MyLibs;

/*
 * 맵의 크기, 유저의 위치, 방향, 맵 을 입력받아서 캐릭터가 방문한 칸의 수를 출력
 * 1. 반시계 뱡향으로 회전
 * 2. 왼쪽에 아직 가보지 않은 칸이 존재한다면, 왼쪽 방향으로 회전한 다음 왼쪽으로 한칸 이동 만약 왼쪽에 길이 없으면 회전만 하고 다시 1번으로 
 * 3. 4방향 모두 이미 가본 칸이거나 바다로 되어 있을 경우, 한칸 뒤로 이동하고 다시 1번으로
 * 
 * 0:북, 1:동, 2:남, 3:서
 */

public class Test04_game {
    public static int row = 4;
    public static int col = 4;
    public static int x = 1;
    public static int y = 1;
    // 0:북,1:동,2:남,3:서
    public static int direction = 0;
    // 북 동 남 서
    public static int[] drow = { -1, 0, 1, 0 };
    public static int[] dcol = { 0, 1, 0, -1 };

    public static void turnLeft() {
        direction--;
        if (direction < 0)
            direction = 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.close();

        int[][] map = { { 1, 1, 1, 1 }, { 1, 0, 0, 1 }, { 1, 1, 0, 1 }, { 1, 1, 1, 1 } };

        map[y][x] = 2;
        int turnCnt = 0;
        int cnt = 1;
        long startTime = System.currentTimeMillis();
        while (true) {
            turnLeft();
            int nrow = y + drow[direction];
            int ncol = x + dcol[direction];

            if (map[nrow][ncol] == 0) {
                map[nrow][ncol] = 2;
                y = nrow;
                x = ncol;
                cnt++;
                turnCnt = 0;
                continue;
            } else
                turnCnt++;

            if (turnCnt == 4) {
                nrow = y - drow[direction];
                ncol = x - dcol[direction];

                if (map[nrow][ncol] == 0) {
                    y = nrow;
                    x = ncol;
                } else
                    break;

                turnCnt = 0;
            }
        }
        long endTime = System.currentTimeMillis();
        MyLibs.pList(map);
        MyLibs.pResult(startTime, endTime, cnt);
    }
}
