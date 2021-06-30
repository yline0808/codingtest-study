package programmers.level2;

import java.util.HashMap;

/*
 * 제목 : 단체사진 찍기
 * url : https://programmers.co.kr/learn/courses/30/lessons/1835
 * 유형 : 2017 카카오코드 본선
 * 
 * 참고 : https://onejunu.tistory.com/92
 */

public class GroupPhoto {
    public static void main(String[] args) {
        String[] data1 = { "N~F=0", "R~T>2" };
        String[] data2 = { "M~C<2", "C~M>1" };
        System.out.println(3648);
        System.out.println(solution(2, data1));
        System.out.println(0);
        System.out.println(solution(2, data2));
    }

    static String[] d;
    static HashMap<Character, Integer> hm;
    static boolean[] visited;
    static int[] ch;
    static int answer;

    public static int solution(int n, String[] data) {
        hm = new HashMap<>();
        visited = new boolean[8];
        ch = new int[8];
        answer = 0;

        hm.put('A', 0);
        hm.put('C', 1);
        hm.put('F', 2);
        hm.put('J', 3);
        hm.put('M', 4);
        hm.put('N', 5);
        hm.put('R', 6);
        hm.put('T', 7);

        dfs(0, data);

        return answer;
    }

    public static void dfs(int idx, String[] data) {
        if (idx == 8 && check(data))
            answer++;
        else {
            for (int i = 0; i < 8; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    ch[idx] = i;
                    dfs(idx + 1, data);
                    visited[i] = false;
                }
            }
        }
    }

    public static boolean check(String[] data) {
        int a, b, res;
        char op;

        for (String s : data) {
            a = ch[hm.get(s.charAt(0))];
            b = ch[hm.get(s.charAt(2))];
            op = s.charAt(3);
            res = s.charAt(4) - '0' + 1;

            switch (op) {
                case '=':
                    if (Math.abs(a - b) != res)
                        return false;
                    break;
                case '>':
                    if (Math.abs(a - b) <= res)
                        return false;
                    break;
                case '<':
                    if (Math.abs(a - b) >= res)
                        return false;
                    break;
            }
        }

        return true;
    }
}
