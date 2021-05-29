package chapter04;

import java.util.Scanner;
import mylib.MyLibs;

/*
 * 체스판에서 나이트의 경로를 입력받으면 몇가지 이동 경로가 있는지 알려주는 프로그램
 */

public class Test02_chess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("input location : ");
        String loc = sc.nextLine().toLowerCase();
        sc.close();
        int row = (int) (loc.charAt(1) - '0');
        int col = (int) (loc.charAt(0) - 'a' + 1);

        // 10시 방향부터 시계방향
        int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
        int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };

        int result = 0;

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 8; i++) {
            if ((row + dy[i] > 0 && col + dx[i] > 0) && (row + dy[i] <= 8 && col + dx[i] <= 8))
                result++;
        }

        long endTime = System.currentTimeMillis();

        MyLibs.pResult(startTime, endTime, result);
    }
}
