package programmers.level2;

/*
 * 문제 : 문자열 압축
 * url : https://programmers.co.kr/learn/courses/30/lessons/60057
 * 유형 : 2020 KAKAO BLIND RECRUITMENT
 */

public class ZipStr {

    public static int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            int zipLevel = 1;
            String zipStr = s.substring(0, i);
            String result = "";

            for (int j = i; j <= s.length(); j += i) {
                if (zipStr.equals(s.substring(j, (j + i > s.length() ? s.length() : j + i))))
                    zipLevel++;
                else {
                    result += (zipLevel == 1 ? "" : zipLevel) + zipStr;
                    zipStr = s.substring(j, (j + i > s.length() ? s.length() : j + i));
                    zipLevel = 1;
                }
            }
            result += zipStr;
            answer = Math.min(answer, result.length());
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(7);
        System.out.println(solution("aabbaccc"));
        System.out.println(9);
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(8);
        System.out.println(solution("abcabcdede"));
        System.out.println(14);
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(17);
        System.out.println(solution("xababcdcdababcdcd"));
    }
}