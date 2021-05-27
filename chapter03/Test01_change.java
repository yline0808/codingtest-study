package chapter03;

/**
 * 거스름돈 걸러주기
 * 
 * 화폐의 종류가 K개라고 할 때 시간복잡도 O(K)
 */
public class Test01_change {
    public static void main(String[] args) {
        final int[] coin = { 500, 100, 50, 10 };
        int change = 1260;
        int cnt = 0;

        for (int i = 0; i < coin.length; i++) {
            cnt += change / coin[i];
            change %= coin[i];
        }

        System.out.println(cnt);
    }
}
