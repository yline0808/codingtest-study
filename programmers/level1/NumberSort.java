package programmers.level1;

import java.util.Arrays;

public class NumberSort {
    public static void main(String[] args) {
        System.out.println(873211);
        System.out.println(solution(118372));
    }

    public static long solution(long n) {
        char[] arr = Long.toString(n).toCharArray();
        Arrays.sort(arr);
        return Long.parseLong(new StringBuffer(new String(arr)).reverse().toString());
    }
}
