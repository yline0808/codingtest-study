package programmers.level2;

/*
 * 문제 : 가장 큰 정사각형 찾기
 * url : https://programmers.co.kr/learn/courses/30/lessons/12905
 * 유형 : 연습문제
 * 
 * 다이나믹 프로그래밍을 활용
 * 다시 보기!!!
 * 참고 : https://soobarkbar.tistory.com/164
 */

public class BigSquare {
    public static void main(String[] args) {
        int[][] board1 = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };
        int[][] board2 = { { 0, 0, 1, 1 }, { 1, 1, 1, 1 } };
        System.out.println(9);
        System.out.println(solution(board1));
        System.out.println(4);
        System.out.println(solution(board2));
    }

    public static int solution(int[][] board) {
        int answer = 0;

        if (board.length == 1 || board[0].length == 1)
            return 1;

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] != 0) {
                    board[i][j] = Math.min(board[i][j - 1], Math.min(board[i - 1][j - 1], board[i - 1][j])) + 1;
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }

        return (int) Math.pow(answer, 2);
    }
}
