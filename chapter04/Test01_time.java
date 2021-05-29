package chapter04;

import java.util.Scanner;
import mylib.MyLibs;

/*
 * 시간 n을 입력하면 N시 59분 59초 까지의 모든 시간중에 3이 하나라도 있는 경우의 수을 반환
 * 
 * 완전 탐색 유형
 */

public class Test01_time {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        System.out.print("input n : ");
        int n = sc.nextInt();
        sc.close();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    if (checkNum(i, j, k))
                        result++;
                }
            }
        }

        long endTime = System.currentTimeMillis();
        MyLibs.pResult(startTime, endTime, result);
    }

    // 이 함수를 생각 못함
    public static boolean checkNum(int i, int j, int k) {
        return (i % 10 == 3 || j / 10 == 3 || j % 10 == 3 || k / 10 == 3 || k % 10 == 3) ? true : false;
    }
}
