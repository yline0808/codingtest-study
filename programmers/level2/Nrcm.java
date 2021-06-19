package programmers.level2;

/*
 * 문제 : N개의 최소공배수
 * url : https://programmers.co.kr/learn/courses/30/lessons/12953
 * 유형 : 연습문제
 * 
 * 참고 : 보통 공약수 관련 문제는 "유클리드 호제법" 사용
 * 최대공배수 = 두 수의 곱 / 최소공약수
 */

public class Nrcm {
    public static void main(String[] args) {
        int[] arr = { 2, 6, 8, 14 };
        System.out.println(168);
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            answer = LCM(answer, arr[i]);
        }

        return answer;
    }

    public static int LCM(int a, int b) {
        return a * b / GCD(a, b);
    }

    public static int GCD(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        return b == 0 ? a : GCD(b, a % b);
    }
}
