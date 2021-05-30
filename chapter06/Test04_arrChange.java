package chapter06;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import mylib.MyLibs;

public class Test04_arrChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input n, k, arr1, arr2");
        int n = sc.nextInt();
        int k = sc.nextInt();
        Integer[] arr1 = new Integer[n];
        Integer[] arr2 = new Integer[n];
        MyLibs.iList(arr1, sc);
        MyLibs.iList(arr2, sc);
        sc.close();

        Arrays.sort(arr1);
        Arrays.sort(arr2, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            if (arr1[i] < arr2[i]) {
                arr1[i] = arr2[i];
            } else
                break;
        }
        int result = 0;

        for (int i = 0; i < n; i++) {
            result += arr1[i];
        }
        System.out.println(result);
    }
}
