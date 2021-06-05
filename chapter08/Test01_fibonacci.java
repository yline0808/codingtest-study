package chapter08;

import mylib.MyLibs;

/*
 * 피보나치 시간 비교
 */

public class Test01_fibonacci {
    public static long fibonacci1(int x) {
        if (x <= 2)
            return 1;
        return fibonacci1(x - 1) + fibonacci1(x - 2);
    }

    public static long[] d = new long[100];

    public static long fibonacci2(int x) {
        if (x <= 2)
            return 1;
        if (d[x] != 0)
            return d[x];
        d[x] = fibonacci2(x - 1) + fibonacci2(x - 2);
        return d[x];
    }

    public static long[] d2 = new long[100];

    public static long fibonacci3(int x) {
        d[1] = 1;
        d[2] = 1;
        if (x <= 2)
            return 1;

        for (int i = 3; i <= x; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        return d[x];
    }

    public static void main(String[] args) {
        long startTime;
        long endTime;
        long result;
        int x = 50;

        startTime = System.currentTimeMillis();
        result = fibonacci1(x);
        endTime = System.currentTimeMillis();
        MyLibs.pResult(startTime, endTime, result);

        startTime = System.currentTimeMillis();
        result = (long) fibonacci2(x);
        endTime = System.currentTimeMillis();
        MyLibs.pResult(startTime, endTime, result);

        startTime = System.currentTimeMillis();
        result = (long) fibonacci3(x);
        endTime = System.currentTimeMillis();
        MyLibs.pResult(startTime, endTime, result);
    }
}
