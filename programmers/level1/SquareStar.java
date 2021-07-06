package programmers.level1;

/*
 * 문제 : 직사각형 별찍기
 * url : https://programmers.co.kr/learn/courses/30/lessons/12969
 * 유형 : 연습문제
 */

public class SquareStar {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++)
            System.out.println("*****");
        System.out.println();
        solution(5, 3);
    }

    public static void solution(int a, int b) {
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
