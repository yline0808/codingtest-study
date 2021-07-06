package programmers.level1;

/*
 * 문제 : 시저 암호
 * url : https://programmers.co.kr/learn/courses/30/lessons/12926
 * 유형 : 연습문제
 */

public class Saesar {
    public static void main(String[] args) {
        System.out.println("BC");
        System.out.println(solution("AB", 1));
        System.out.println("a");
        System.out.println(solution("z", 1));
        System.out.println("e F d");
        System.out.println(solution("a B z", 4));
    }

    public static String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z')
                sb.append(c + n > 'z' ? (char) (c + n - 26) : (char) (c + n));
            else if (c >= 'A' && c <= 'Z')
                sb.append(c + n > 'Z' ? (char) (c + n - 26) : (char) (c + n));
            else
                sb.append(c);
        }

        return sb.toString();
    }
}
