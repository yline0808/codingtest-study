package chapter08;

/*
 * 인접하지 않은 두개의 수를 배열에서 뽑아 두 수의 합이 가장 큰 경우의 합을 반환
 */

public class Test03_antMan {
    public static int[] d = new int[100];

    public static void main(String[] args) {
        int[] arr = { 1, 3, 1, 5, 1, 7, 2, 9 };

        d[0] = arr[0];
        d[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            d[i] = Math.max(d[i - 1], d[i - 2] + arr[i]);
        }
        System.out.println(d[arr.length - 1]);
    }
}