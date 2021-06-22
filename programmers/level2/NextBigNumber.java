package programmers.level2;

/*
 * 문제 : 다음 큰 숫자
 * url : https://programmers.co.kr/learn/courses/30/lessons/12911
 * 유형 : 연습문제
 */

public class NextBigNumber {
    public static void main(String[] args) {
        System.out.println(83);
        System.out.println(solution(78));
        System.out.println(23);
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        int answer = n;
        int nCnt = countOneNumber(Integer.toBinaryString(n));
        int nnCnt = 0;

        while (nnCnt != nCnt) {
            nnCnt = countOneNumber(Integer.toBinaryString(++answer));
        }

        return answer;
    }

    public static int countOneNumber(String binN) {
        int cnt = 0;

        for (int i = 0; i < binN.length(); i++)
            if ('1' == binN.charAt(i))
                cnt++;

        return cnt;
    }
}
