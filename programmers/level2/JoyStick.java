package programmers.level2;

/*
 * 문제 : 조이스특
 * url : https://programmers.co.kr/learn/courses/30/lessons/42860
 * 유형 : 탐욕법(Greedy)
 */

public class JoyStick {
    public static void main(String[] args) {
        System.out.println(56);
        System.out.println(solution("JEROEN"));
        System.out.println(23);
        System.out.println(solution("JAN"));
    }

    public static int solution(String name) {
        int answer = 0;
        int len = name.length();
        int min = len - 1;

        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            int mov = (c - 'A' < 'Z' - c + 1) ? (c - 'A') : ('Z' - c + 1);
            answer += mov;

            int nextIndex = i + 1;

            while (nextIndex < len && name.charAt(nextIndex) == 'A')
                nextIndex++;

            // 이부분 잘 모름...
            min = Math.min(min, (i * 2) + len - nextIndex);
        }

        answer += min;

        return answer;
    }
}
