package programmers.level1;

/*
 * 제목 : 키패드 누르기
 * url : https://programmers.co.kr/learn/courses/30/lessons/67256
 * 유형 : 2020 카카오 인턴십
 */

public class KeyPad {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
        System.out.println("LLRLLRLLRL");
        System.out.println(solution(numbers, "right"));
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int[] left = { 3, 0 };
        int[] right = { 3, 2 };

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0)
                numbers[i] = 11;
            if (numbers[i] % 3 == 1) {
                answer += "L";
                left = setCoordinate(numbers[i]);
            } else if (numbers[i] % 3 == 0) {
                answer += "R";
                right = setCoordinate(numbers[i]);
            } else {
                int leftDist = Math.abs(left[0] - (numbers[i] - 1) / 3) + Math.abs(left[1] - (numbers[i] - 1) % 3);
                int rightDist = Math.abs(right[0] - (numbers[i] - 1) / 3) + Math.abs(right[1] - (numbers[i] - 1) % 3);
                if (leftDist == rightDist) {
                    if (hand.equals("left")) {
                        answer += "L";
                        left = setCoordinate(numbers[i]);
                    } else {
                        answer += "R";
                        right = setCoordinate(numbers[i]);
                    }
                } else {
                    if (leftDist < rightDist) {
                        answer += "L";
                        left = setCoordinate(numbers[i]);
                    } else {
                        answer += "R";
                        right = setCoordinate(numbers[i]);
                    }
                }
            }
        }

        return answer;
    }

    public static int[] setCoordinate(int num) {
        int[] coordinate = new int[2];
        coordinate[0] = (num - 1) / 3;
        coordinate[1] = (num - 1) % 3;
        return coordinate;
    }
}
