package programmers.level1;

/*
 * 문제 : 2016년
 * url : https://programmers.co.kr/learn/courses/30/lessons/12901
 * 유형 : 연습문제
 */

public class Year2016 {
    public static void main(String[] args) {
        System.out.println(solution(5, 24));
    }

    public static String solution(int a, int b) {
        String[] week = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
        int[] month = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int day = 4;

        for (int i = 0; i < a - 1; i++) {
            day += month[i];
        }
        day += b;

        return week[day % 7];
    }
}
