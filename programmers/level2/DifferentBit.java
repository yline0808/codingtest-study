package programmers.level2;

import mylib.MyLibs;

/*
 * 문제 : 2개 이하로 다른 비트
 * url : https://programmers.co.kr/learn/courses/30/lessons/77885
 * 유형 : 월간 코드 챌린지 시즌2
 */

public class DifferentBit {
    public static void main(String[] args) {
        long[] numbers = { 2, 7 };
        System.out.println("3\t11");
        MyLibs.pList(solution(numbers));
    }

    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                String binaryString = Long.toBinaryString(numbers[i]);
                int lastZero = binaryString.lastIndexOf("0");
                int nextOne = binaryString.indexOf("1", lastZero);

                if (lastZero == -1) {
                    binaryString = Long.toBinaryString(++numbers[i]);
                    binaryString = binaryString.substring(0, 2)
                            + binaryString.substring(2, binaryString.length()).replace("0", "1");
                } else {
                    binaryString = binaryString.substring(0, lastZero) + "1"
                            + binaryString.substring(lastZero + 1, nextOne) + "0"
                            + binaryString.substring(nextOne + 1, binaryString.length());
                }
                answer[i] = Long.parseLong(binaryString, 2);
            }
        }

        return answer;
    }

    public long[] solutionBest(long[] numbers) {
        long[] answer = numbers.clone();
        for (int i = 0; i < answer.length; i++) {
            answer[i]++;
            answer[i] += (answer[i] ^ numbers[i]) >>> 2;
        }
        return answer;
    }
}
