package programmers.level1;

import java.util.ArrayList;

/*
 * 제목 : 크레인 인형뽑기 게임
 * url : https://programmers.co.kr/learn/courses/30/lessons/64061
 * 유형 : 2019카카오 개발자 겨울 인턴십
 */

public class DollSelect {
    public static void main(String[] args) {
        int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
                { 3, 5, 1, 3, 1 } };
        int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
        System.out.println("정답 : 4");
        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] != 0) {
                    list.add(board[j][moves[i] - 1]);
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
            if (list.size() > 1 && (list.get(list.size() - 1) == list.get(list.size() - 2))) {
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
                answer += 2;
            }
        }

        return answer;
    }
}
