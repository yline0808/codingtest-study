package programmers.level1;

/*
 * 문제 : 수박수박
 * url : https://programmers.co.kr/learn/courses/30/lessons/12922
 * 유형 : 연습문제
 */

public class WaterMelon {
    public static void main(String[] args) {
        System.out.println("수박수");
        System.out.println(soluiton(3));
    }

    public static String soluiton(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(i % 2 == 0 ? "수" : "박");
        return sb.toString();
    }
}
