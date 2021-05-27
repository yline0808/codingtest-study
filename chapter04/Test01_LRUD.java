package chapter04;

import java.util.Scanner;

import mylib.MyPrinter;

/*
 * n x n 의 지도가 있고 시작지점은 항상 1, 1
 * L R U D 4개 방향의 계획이 주어지는데 지도 밖으로 벗어나는 계획은 무시하여 최종적으로 도착하는 지점을 반환
 */

public class Test01_LRUD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("input n, plan : ");
        int[] result = { 1, 1 };
        int n = scanner.nextInt();
        String[] plan = scanner.nextLine().toLowerCase().split(" ");
        scanner.close();

        String[] moveType = { "l", "r", "u", "d" };
        int[] row = { 0, 0, -1, 1 };
        int[] col = { -1, 1, 0, 0 };

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < plan.length; i++) {
            int[] nextMove = new int[2];

            for (int j = 0; j < moveType.length; j++) {
                if (moveType[j].equals(plan[i])) {
                    nextMove[0] = result[0] + row[j];
                    nextMove[1] = result[1] + col[j];
                }
            }

            if (nextMove[0] < 1 || nextMove[1] < 1 || nextMove[0] > n || nextMove[1] > n) {
                continue;
            }
            result[0] = nextMove[0];
            result[1] = nextMove[1];
        }

        long endTime = System.currentTimeMillis();
        MyPrinter.pResult(startTime, endTime, result);
    }
}
