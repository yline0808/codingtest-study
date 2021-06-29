package programmers.level2;

import mylib.MyLibs;

/*
 * 문제 : 카펫
 * url : https://programmers.co.kr/learn/courses/30/lessons/42842
 * 유형 : 완전탐색
 */

public class Carpet {
    public static void main(String[] args) {
        System.out.println("4\t3");
        MyLibs.pList(solution(10, 2));
        System.out.println("3\t3");
        MyLibs.pList(solution(8, 1));
        System.out.println("8\t6");
        MyLibs.pList(solution(24, 24));
    }

    public static int[] solution(int brown, int yellow) {
        for (int i = 1; i <= yellow; i++)
            if (yellow % i == 0 && ((yellow / i + i) * 2 + 4) == brown)
                return new int[] { yellow / i + 2, i + 2 };
        return null;
    }
}
