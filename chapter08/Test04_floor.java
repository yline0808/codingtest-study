package chapter08;

/*
 * 가로 : n, 세로 : 2 인 바닥을 1x2, 2x1, 2x2 의 덮개를 이용해 채우려고 한다.
 * 모든 바닥을 채우는 모든 경우의 수를 구하는 프로그램 작성
 * (수가 커질 수도 있어서 796796로 나눈 나머지를 구하기)
 */

public class Test04_floor {
    public static int[] d = new int[1000];

    public static void main(String[] args) {
        int n = 3;

        d[0] = 1;
        d[1] = 3;
        for (int i = 2; i < n; i++) {
            d[i] = (d[i - 1] + d[i - 2] * 2) % 796796;
        }
        System.out.println(d[n - 1]);
    }
}