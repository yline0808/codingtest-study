package programmers.level2;

/*
 * 문제 : 예상 대진표
 * url : https://programmers.co.kr/learn/courses/30/lessons/12985
 * 유형 : 2017 팁스타운
 */

public class PredictionTable {
    public static void main(String[] args) {
        System.out.println(3);
        System.out.println(solutionMy(8, 4, 7));
        System.out.println(solutionXOR(8, 4, 7));
        System.out.println(solutionOther(8, 4, 7));
    }

    public static int solutionMy(int n, int a, int b) {
        int answer = 1;
        int left = Math.min(a, b);
        int right = Math.max(a, b);

        while (true) {
            if (left % 2 != 0 && right == (left + 1))
                break;
            left = (left + 1) / 2;
            right = (right + 1) / 2;
            answer++;
        }

        return answer;
    }

    public static int solutionXOR(int n, int a, int b) {
        return Integer.toBinaryString((a - 1) ^ (b - 1)).length();
    }

    public static int solutionOther(int n, int a, int b) {
        int answer = 0;
        while (a != b) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer++;
        }
        return answer;
    }
}
