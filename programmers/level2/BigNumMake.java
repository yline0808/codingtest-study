package programmers.level2;

/*
 * 문제 : 큰 수 만들기
 * url : https://programmers.co.kr/learn/courses/30/lessons/42883
 * 유형 : 탐욕법
 */

public class BigNumMake {
    public static void main(String[] args) {
        System.out.println(94);
        System.out.println(solution("1924", 2));
        System.out.println(3234);
        System.out.println(solution("1231234", 3));
        System.out.println(775841);
        System.out.println(solution("4177252841", 4));
    }

    public static String solution(String number, int k) {
        String answer = "";
        int cnt = 0;
        int j = 0;
        for (int i = 0; i < number.length(); i++) {

            if (cnt < k && number.charAt(i) < number.charAt(i + 1)) {
                cnt++;
                continue;
            }
            answer += number.charAt(i);
        }

        return answer;
    }
}
