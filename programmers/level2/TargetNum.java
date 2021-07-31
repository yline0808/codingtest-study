package programmers.level2;

/*
 * 제목 : 타겟 넘버
 * url : https://programmers.co.kr/learn/courses/30/lessons/43165
 * 유형 : 깊이/너비 우선 탐색(DFS/BFS)
 */

public class TargetNum {
    public static void main(String[] args) {
        int[] numbers = { 1, 1, 1, 1, 1 };
        int target = 3;

        System.out.println(5);
        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, 0);
        return answer;
    }

    public static int dfs(int[] numbers, int target, int index, int num) {
        if (numbers.length == index)
            return target == num ? 1 : 0;
        else
            return dfs(numbers, target, index + 1, num + numbers[index])
                    + dfs(numbers, target, index + 1, num - numbers[index]);
    }
}
