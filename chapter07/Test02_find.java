package chapter07;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * n개의 부품이 있고 m개의 부품을 찾을때 부품이 있으면 yes 없으면 no를 요청 부품 순서대로 출력
 */

public class Test02_find {
    public static String find(int[] arr, int value) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == value)
                return "yes";
            else if (arr[mid] > value)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return "no";
    }

    public static void main(String[] args) {
        int[] arr1 = { 8, 3, 7, 9, 2 };
        int[] arr2 = { 5, 7, 9 };
        ArrayList<String> result = new ArrayList<>();

        Arrays.sort(arr1);

        for (int i = 0; i < arr2.length; i++) {
            // result.add(find(arr1, arr2[i]));
            System.out.println(find(arr1, arr2[i]));
        }

        System.out.println(result.toString());
    }
}
