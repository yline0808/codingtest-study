package chapter05;

import mylib.MyLibs;

/*
 * n x m 크기의 얼음 틀이 있다 구멍 : 0, 칸막이 : 1
 * 구멍이 뚫려 있는 부분끼리 상,하,좌,우 로 붙어 있는 경우 서로 연결되어 있는것
 * 생성되는 아이스크림의 개수를 구하시오
 * 
 */

public class Test03_ice {
    public static int row = 15, col = 14;

    public static boolean dfs(int[][] arr, int x, int y) {
        if (x < 0 || x >= col || y < 0 || y >= row)
            return false;
        if (arr[y][x] == 0) {
            arr[y][x] = 1;
            dfs(arr, x - 1, y);
            dfs(arr, x + 1, y);
            dfs(arr, x, y - 1);
            dfs(arr, x, y + 1);
            return true;
        } else
            return false;
    }

    public static void main(String[] args) {
        int result = 0;
        // int[][] arr1 = { { 0, 0, 1, 1, 0 }, { 0, 0, 0, 1, 1 }, { 1, 1, 1, 1, 1 }, {
        // 0, 0, 0, 0, 0 }, };
        int[][] arr2 = { { 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0 }, { 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
                { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
                { 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1 }, { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 } };

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(arr2, j, i))
                    result++;
            }
        }

        long endTime = System.currentTimeMillis();
        MyLibs.pResult(startTime, endTime, result);
    }
}
