package programmers.level1;

/*
 * 제목 : 소수 만들기
 * url : https://programmers.co.kr/learn/courses/30/lessons/12977
 * 유형 : Summer/Winter Coding(~2018)
 */

public class PrimeNumber {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 7, 6, 4 };
        System.out.println(4);
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (isPrimeNumber(nums[i] + nums[j] + nums[k]))
                        answer++;
                }
            }
        }

        return answer;
    }

    public static boolean isPrimeNumber(int num) {
        int cnt = 0;

        for (int i = 1; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0)
                cnt++;
        }
        return cnt == 1;
    }
}
