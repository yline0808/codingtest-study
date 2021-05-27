package chapter03;

import java.util.Scanner;
/*
 * 어떤 수 N이 1이 될 때까지 아래 2개의 과정을 선택해서 반복 (K도 입력받아야함)
 * 1. N에서 1을 뺀다.
 * 2. N을 K로 나눈다.
 * 
 * 최소 과정을 구하기
 */

import mylib.MyPrinter;

public class Test04_untilOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("input n, k : ");
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int result = 0;

        scanner.close();

        long startTime = System.currentTimeMillis();

        // sol
        while (true) {
            int target = (n / k) * k;
            result += (n - target);
            n = target;
            if (n < k)
                break;
            result += 1;
            n /= k;
        }
        result += (n - 1); // 여기서 그냥 -1 하면 안되나?...

        // my code
        // while (n != 1) {
        // if (n % k == 0)
        // n /= k;
        // else
        // n--;
        // result++;
        // }

        long endTime = System.currentTimeMillis();

        MyPrinter.pResult(startTime, endTime, result);
    }
}
