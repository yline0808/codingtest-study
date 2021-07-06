package programmers.level1;

/*
 * 문제 : 3진법 뒤집기
 * url : https://programmers.co.kr/learn/courses/30/lessons/68935
 * 유형 : 월간 코드 챌린지 시즌1
 */

public class TernaryFlip {
    public static void main(String[] args) {
        System.out.println(7);
        System.out.println(solution(45));
        System.out.println(229);
        System.out.println(solution(125));
    }

    public static int solution(int n) {
        return Integer.parseInt(new StringBuffer(Integer.toString(n, 3)).reverse().toString(), 3);
    }
}
