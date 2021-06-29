package programmers.level2;

import java.util.HashSet;

/*
 * 문제 : 소수 찾기
 * url : https://programmers.co.kr/learn/courses/30/lessons/42839
 * 유형 : 완전탑색
 */

public class FindPrime {
    public static void main(String[] args) {
        System.out.println(3);
        System.out.println(solution("17"));
        System.out.println(2);
        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();

        premutation("", numbers, set);

        int count = 0;

        while (set.iterator().hasNext()) {
            int a = set.iterator().next();
            set.remove(a);
            if (isPrimeNumber(a))
                count++;
        }
        return count;
    }

    public static void premutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();

        if (!prefix.equals(""))
            set.add(Integer.parseInt(prefix));
        for (int i = 0; i < n; i++)
            premutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
    }

    public static boolean isPrimeNumber(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= (int) Math.sqrt(num); i++)
            if (num % i == 0)
                return false;

        return true;
    }
}
