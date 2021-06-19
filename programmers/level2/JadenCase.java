package programmers.level2;

/*
 * 문제 : JadenCase 문자열 만들기
 * url : https://programmers.co.kr/learn/courses/30/lessons/12951
 * 유형 : 연습문제
 */

public class JadenCase {
    public static void main(String[] args) {
        System.out.println("3people Unfollowed Me");
        System.out.println(solution("3people unFollowed me"));
        System.out.println("For The Last Week");
        System.out.println(solution("for the last week"));
    }

    public static String solution(String s) {
        String answer = String.valueOf(s.charAt(0)).toUpperCase();

        for (int i = 1; i < s.length(); i++)
            answer += s.charAt(i - 1) == ' ' ? String.valueOf(s.charAt(i)).toUpperCase()
                    : String.valueOf(s.charAt(i)).toLowerCase();

        return answer;
    }
}
