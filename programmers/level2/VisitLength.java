package programmers.level2;

/*
 * 문제 : 방문 길이
 * url : https://programmers.co.kr/learn/courses/30/lessons/49994
 * 유형 : Summer/Winter Coding(~2018)
 */

public class VisitLength {
    public static void main(String[] args) {
        System.out.println(7);
        System.out.println(solution("ULURRDLLU"));
        System.out.println(7);
        System.out.println(solution("LULLLLLLU"));
    }

    public static int solution(String dirs) {
        int answer = 0;
        boolean[][][][] check = new boolean[11][11][11][11];
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        int x = 0, y = 0, nx = 5, ny = 5;
        int index = 0;

        for (int i = 0; i < dirs.length(); i++) {
            x = nx;
            y = ny;

            if (dirs.charAt(i) == 'R')
                index = 0;
            else if (dirs.charAt(i) == 'L')
                index = 1;
            else if (dirs.charAt(i) == 'D')
                index = 2;
            else
                index = 3;

            nx = x + dx[index];
            ny = y + dy[index];

            if (nx < 0 || ny < 0 || nx > 10 || ny > 10) {
                nx = x;
                ny = y;
                continue;
            }
            if (!check[y][x][ny][nx]) {
                answer++;
                check[y][x][ny][nx] = true;
                check[ny][nx][y][x] = true;
            }
        }

        return answer;
    }
}
