package programmers.level2;

/*
 * 제목 : 땅 따먹기
 * url : https://programmers.co.kr/learn/courses/30/lessons/12913
 * 유형 : 연습문제
 */

public class LandGat {
    public static void main(String[] args) {
        int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
        System.out.println(16);
        System.out.println(solution(land));
    }

    public static int solution(int[][] land) {
        int answer = 0;

        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }

        for (int i = 0; i < 4; i++)
            if (land[land.length - 1][i] > answer)
                answer = land[land.length - 1][i];

        return answer;
    }
}
