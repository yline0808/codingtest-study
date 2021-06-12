package programmers.level1;

/*
 * 제목 : 체육복
 * url : https://programmers.co.kr/learn/courses/30/lessons/42862
 * 유형 : 탐욕볍
 */

public class GymSuit {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = { 2, 4 };
        int[] reserve = { 1, 3, 5 };
        System.out.println(solution(n, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n + 2];

        for (int i = 0; i < reserve.length; i++) {
            arr[reserve[i]]++;
        }
        for (int i = 0; i < lost.length; i++) {
            arr[lost[i]]--;
        }
        for (int i = 0; i < lost.length; i++) {
            if (arr[lost[i]] < 0 && arr[lost[i] - 1] > 0) {
                arr[lost[i] - 1]--;
                arr[lost[i]]++;
            } else if (arr[lost[i]] < 0 && arr[lost[i] + 1] > 0) {
                arr[lost[i] + 1]--;
                arr[lost[i]]++;
            } else {
                continue;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (arr[i] >= 0)
                answer++;
        }

        return answer;
    }
}
