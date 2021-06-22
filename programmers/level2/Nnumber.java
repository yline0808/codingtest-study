package programmers.level2;

/*
 * 문제 : [3차 n진수 게임]
 * url : https://programmers.co.kr/learn/courses/30/lessons/17687
 * 유형 : 2018 KAKAO BLIND RECRUITMENT
 */

public class Nnumber {
    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        int num = 0;
        while (t * m > answer.length()) {
            answer += nNumber(num++, n);
        }
        String result = "";
        num = p - 1;
        while (result.length() < t) {
            if (num % m == (p - 1)) {
                result += answer.charAt(num);
            }
            num++;
        }

        return result;
    }

    public static String nNumber(int num, int n) {
        String str = "";
        String[] numToAlpha = { "A", "B", "C", "D", "E", "F" };
        while (num > 0) {
            if (num % n < 10) {
                str = (num % n) + str;
            } else {
                str = numToAlpha[(num % n) - 10] + str;
            }
            num /= n;
        }
        return str.length() == 0 ? "0" : str;
    }

    public static String solutionBest(int n, int t, int m, int p) {
        int startNum = 0;
        String targetString = new String();
        String retString = new String();

        while (targetString.length() < m * t) {
            targetString += Integer.toString(startNum++, n);
        }

        for (int i = 0; i < t; i++) {
            retString += targetString.charAt(p - 1 + i * m);
        }

        return retString.toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println("진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p 가 주어진다.");
        System.out.println("0111");
        System.out.println(solution(2, 4, 2, 1) + "\n");
        System.out.println("02468ACE11111111");
        System.out.println(solution(16, 16, 2, 1) + "\n");
        System.out.println("13579BDF01234567");
        System.out.println(solution(16, 16, 2, 2) + "\n");

        System.out.println("========================");
        System.out.println("0111");
        System.out.println(solutionBest(2, 4, 2, 1) + "\n");
        System.out.println("02468ACE11111111");
        System.out.println(solutionBest(16, 16, 2, 1) + "\n");
        System.out.println("13579BDF01234567");
        System.out.println(solutionBest(16, 16, 2, 2) + "\n");
    }
}
