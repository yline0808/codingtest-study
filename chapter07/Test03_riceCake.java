package chapter07;

/*
 * 높이가 19, 14, 10, 17이고 절단기의 높이가 15일 때
 * 자른 뒤 떡은 15, 14, 10, 15 이고 잘린 떡은 4, 0, 0, 2이다.
 * 손님은 6의 길이를 가져간다
 * 이 때 가작 높은 절단기의 높이를 구하시오
 */

public class Test03_riceCake {

    public static void main(String[] args) {
        int n = 4;
        int m = 6;
        int[] arr = { 19, 15, 10, 17 };

        int start = 0;
        int end = (int) 1e9;
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            long total = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid)
                    total += arr[i] - mid;
            }
            if (total < m)
                end = mid - 1;
            else {
                result = mid;
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}
