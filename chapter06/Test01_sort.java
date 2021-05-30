package chapter06;

import mylib.MyLibs;

public class Test01_sort {
    public static int[] array = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };

    public static void main(String[] args) {
        selectionSort();
        insertSort();
        quickSort();
        gsSort();
    }

    public static void selectionSort() {
        int[] arr = array.clone();

        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }
        MyLibs.pList(arr);
    }

    public static void insertSort() {
        int[] arr = array.clone();

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                } else
                    break;
            }
        }
        MyLibs.pList(arr);
    }

    public static void quickSort() {
        int[] arr = array.clone();

        quickSort(arr, 0, arr.length - 1);

        MyLibs.pList(arr);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && arr[left] <= arr[pivot])
                left++;
            while (right > start && arr[right] >= arr[pivot])
                right--;

            if (left > right) {
                int tmp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = tmp;
            } else {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }

    public static void gsSort() {
        int n = 15;
        int[] arr = { 7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2 };
        int[] cnt = new int[10];

        for (int i = 0; i < n; i++) {
            cnt[arr[i]] += 1;
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
