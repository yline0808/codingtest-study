package chapter08;

import java.util.Arrays;
import java.util.Scanner;

import mylib.MyLibs;

/*
 * 화폐의 종류 : n (1 <= n <= 100), 가격 : m (1 <= m <= 10000), 거스름돈 단위 배열로 받기
 */

public class Test05_money {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int[] d = new int[m + 1];
        Arrays.fill(d, 10001);
        d[0] = 0;
        MyLibs.iList(arr, sc);
        sc.close();

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++) {
                if (d[j - arr[i]] != 10001) {
                    d[j] = Math.min(d[j], d[j - arr[i]] + 1);
                }
            }
        }
        System.out.println(d[m] == 10001 ? -1 : d[m]);
    }
}
