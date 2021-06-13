package programmers.level2;

import java.util.ArrayList;

/*
 * 제목 : 짝지어 제거하기
 * url : https://programmers.co.kr/learn/courses/30/lessons/12973
 * 유형 : 2017 팁스타운
 */

public class SameRemove {
    public static void main(String[] args) {
        String s = "baabaa";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        ArrayList<Character> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
            if (list.size() > 1 && (list.get(list.size() - 1) == list.get(list.size() - 2))) {
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
            }
        }

        return list.size() > 0 ? 0 : 1;
    }
}
