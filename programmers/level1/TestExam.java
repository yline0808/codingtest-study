package programmers.level1;

import java.util.ArrayList;

import mylib.MyLibs;

/*
 * 제목 : 모의고사
 * url : https://programmers.co.kr/learn/courses/30/lessons/42840
 * 유형 : 완전탐색
 */

public class TestExam {
    public static void main(String[] args) {
        int[] answers = { 1, 3, 2, 4, 2 };
        MyLibs.pList(solution(answers));
    }

    public static int[] solution(int[] answers) {
        int[] user1 = { 1, 2, 3, 4, 5 };
        int[] user2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] user3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        int[] score = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == user1[i % user1.length])
                score[0]++;
            if (answers[i] == user2[i % user2.length])
                score[1]++;
            if (answers[i] == user3[i % user3.length])
                score[2]++;
        }

        int max = Math.max(Math.max(score[0], score[1]), score[2]);

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (max == score[i])
                list.add(i + 1);
        }

        return list.stream().mapToInt(i -> i.intValue()).toArray();
    }
}
