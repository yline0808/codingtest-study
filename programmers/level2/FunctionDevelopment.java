package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import mylib.MyLibs;

/*
 * 제목 : 기능개발
 * url : https://programmers.co.kr/learn/courses/30/lessons/42586
 * 유형 : 스택/큐
 */

public class FunctionDevelopment {
    public static void main(String[] args) {
        int[] progresses = { 93, 30, 55 };
        int[] speeds = { 1, 30, 5 };
        MyLibs.pList(new int[] { 2, 1 });
        MyLibs.pList(solution(progresses, speeds));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            q.offer((100 - progresses[i]) % speeds[i] == 0 ? (100 - progresses[i]) / speeds[i]
                    : (100 - progresses[i]) / speeds[i] + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        int start = q.poll();
        int count = 1;

        while (!q.isEmpty()) {
            int next = q.poll();

            if (start >= next) {
                count++;
            } else {
                list.add(count);
                start = next;
                count = 1;
            }
        }
        list.add(count);

        return list.stream().mapToInt(i -> i).toArray();
    }
}
