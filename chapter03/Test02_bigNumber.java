package chapter03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 큰수의 법칙
 * 
 * 순서대로 N크기 배열이 주어지고 M번 더하기를 진행합니다. 단, 연속으로 K번만 더할 수 있습니다.
 * 
 * ===test1===
 * 식을 만들어서 하는 방법
 * (m / (k + 1)) * k + (m % (k + 1))
 * (m / (k + 1))
 * 
 * ===test2===
 * 기본적인 방법
 */

public class Test02_bigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("배열의 크기N, 더하기 수M, 연속 수K, 숫자 배열을 입력 : ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        scanner.close();

        System.out.printf("%d %d %d\n", n, m, k);
        System.out.println(arr.toString());
        Collections.sort(arr, Collections.reverseOrder());
        int bigNum = (int) arr.get(0);
        int smallNum = (int) arr.get(1);

        // =======test1=========
        long startTime = System.currentTimeMillis();
        int result = bigNum * (m / (k + 1)) * k + (m % (k + 1)) + smallNum * (m / (k + 1));
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + ":result : " + result);

        // =======test2=========
        result = 0;
        startTime = System.currentTimeMillis();

        while (true) {
            for (int i = 0; i < k; i++) {
                if (m == 0) {
                    break;
                }
                result += bigNum;
                m--;
            }
            if (m == 0) {
                break;
            }
            result += smallNum;
            m--;
        }

        endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + ":return : " + result);
    }
}
