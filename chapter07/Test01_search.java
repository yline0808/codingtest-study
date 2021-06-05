package chapter07;

import mylib.MyLibs;

public class Test01_search {
    public static int normalSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int treeSearch(int[] arr, int value, int start, int end) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        if (arr[mid] == value)
            return mid;
        else if (arr[mid] > value)
            return treeSearch(arr, value, start, mid - 1);
        else
            return treeSearch(arr, value, mid + 1, end);
    }

    public static int treeSearch2(int[] arr, int value, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == value)
                return mid;
            else if (arr[mid] > value)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int arrSize = 100000000;
        int[] arr = new int[arrSize];
        int result;

        for (int i = 0; i < arrSize; i++) {
            arr[i] = i;
        }

        long startTime = System.currentTimeMillis();
        result = normalSearch(arr, arrSize - 1);
        long endTime = System.currentTimeMillis();
        MyLibs.pResult(startTime, endTime, result);

        startTime = System.currentTimeMillis();
        result = treeSearch(arr, arrSize - 1, 0, arrSize - 1);
        endTime = System.currentTimeMillis();
        MyLibs.pResult(startTime, endTime, result);

        startTime = System.currentTimeMillis();
        result = treeSearch2(arr, arrSize - 1, 0, arrSize - 1);
        endTime = System.currentTimeMillis();
        MyLibs.pResult(startTime, endTime, result);
    }
}
