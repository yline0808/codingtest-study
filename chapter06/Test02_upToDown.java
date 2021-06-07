package chapter06;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Test02_upToDown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("input size : ");
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
