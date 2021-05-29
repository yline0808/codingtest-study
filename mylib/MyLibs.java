package mylib;

import java.util.Scanner;

public class MyLibs {
    public static void pList(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }

    public static void pList(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            pList(arr[i]);
        }
    }

    public static void pResult(long startTime, long endTime, int result) {
        System.out.printf("%f : result : %d\n", (endTime - startTime) / 1000.0, result);
    }

    public static void pResult(long startTime, long endTime, int[] result) {
        System.out.printf("%f : result : ", (endTime - startTime) / 1000.0);
        pList(result);
    }

    public static void iList(int[] arr, Scanner sc) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static void iList(int[][] arr, Scanner sc) {
        for (int i = 0; i < arr.length; i++) {
            iList(arr[i], sc);
        }
    }
}