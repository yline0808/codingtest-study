package programmers.level2;

import java.util.Arrays;

/*
 * 문제 : H-Index
 * url : https://programmers.co.kr/learn/courses/30/lessons/42747
 * 유형 : 정렬
 * 
 * 참고 : 문제가 모르겠고 이건 안나올듯
 */

public class HIndex {
    public static void main(String[] args) {
        int[] citations = { 3, 0, 6, 1, 5 };
        System.out.println(3);
        System.out.println(solutionBest(citations));
    }

    public static int solutionBest(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int smaller = Math.min(citations[i], citations.length - i);
            answer = Math.max(answer, smaller);
        }
        return answer;
    }

    public static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > answer)
                answer++;
            else
                break;
        }

        return answer;
    }
}
