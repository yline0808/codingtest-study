package mylib;

import java.util.Scanner;

public class MyLibs {
    public static void pList(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d\t", arr[i]);
        }
        System.out.println();
    }

    public static void pList(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d\t", arr[i]);
        }
        System.out.println();
    }

    public static void pList(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s\t", arr[i]);
        }
        System.out.println();
    }

    public static void pList(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            pList(arr[i]);
        }
    }

    public static void pList(Integer[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            pList(arr[i]);
        }
    }

    public static void pList(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            pList(arr[i]);
        }
    }

    public static void pResult(long startTime, long endTime, int result) {
        System.out.printf("%f : result : %d\n", (endTime - startTime) / 1000.0, result);
    }

    public static void pResult(long startTime, long endTime, long result) {
        System.out.printf("%f : result : %d\n", (endTime - startTime) / 1000.0, result);
    }

    public static void pResult(long startTime, long endTime, String result) {
        System.out.printf("%f : result : %s\n", (endTime - startTime) / 1000.0, result);
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

    public static void iList(Integer[] arr, Scanner sc) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static void iList(int[][] arr, Scanner sc) {
        for (int i = 0; i < arr.length; i++) {
            iList(arr[i], sc);
        }
    }

    public static void iList(Integer[][] arr, Scanner sc) {
        for (int i = 0; i < arr.length; i++) {
            iList(arr[i], sc);
        }
    }
}
