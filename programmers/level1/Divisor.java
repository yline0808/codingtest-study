package programmers.level1;

/*
 * 제목 : 약수의 개수와 덧셈
 * url : https://programmers.co.kr/learn/courses/30/lessons/77884?language=java
 * 유형 : 월간 코드 챌린지 시즌2
 * 
 * 참고 : 자연수가 제곱수라면 그 수의 약수는 홀수개, 아니면 짝수개
 */

public class Divisor {
    public static void main(String[] args) {
        System.out.println(solution(13, 17));
    }

    public static int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            answer += Math.sqrt(i) % 1 == 0 ? -i : i;
        }
        return answer;
    }
}
