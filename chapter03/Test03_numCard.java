package chapter03;

import java.util.Arrays;
import java.util.Scanner;
import mylib.MyLibs;

/*
 * N : 행, M : 열
 * 행에서 가장 작은 숫자를 뽑는데 행 중에서는 가장 큰 숫자여야 함
 */

public class Test03_numCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("input N & M & ARR : ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int result = 0;
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        System.out.printf("%d, %d\n", n, m);
        MyLibs.pList(arr);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            Arrays.sort(arr[i]);
            if (result < arr[i][0]) {
                result = arr[i][0];
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("%f : result : %d\n", (endTime - startTime) / 1000.0, result);
    }
}
