package chapter08;

/*
 * 4가지 연산을 통해 1로 만들기
 * 1. x 가 5로 나우어떨어지면, 5로 나눈다.
 * 2. x 가 3으로 나누어떨어지면, 3으로 나눈다.
 * 3. x 가 2로 나누어떨어지면, 2로 나눈다.
 * 4. x 에서 1을 뺀다.
 */

public class Test02_one {
    public static void main(String[] args) {
        int n = 26;
        int[] d = new int[30001];

        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;

            if (i % 2 == 0)
                d[i] = Math.min(d[i], d[i / 2] + 1);
            if (i % 3 == 0)
                d[i] = Math.min(d[i], d[i / 3] + 1);
            if (i % 5 == 0)
                d[i] = Math.min(d[i], d[i / 5] + 1);
        }

        System.out.println(d[n]);
    }
}
