package chapter10;

public class Test01_cycle {
    public static int v, e;
    public static int[] parent = new int[100001];

    public static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) {
        v = 3;
        e = 3;
        int[][] arr = { { 1, 2 }, { 1, 3 }, { 2, 3 } };

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        boolean cycle = false;

        for (int i = 0; i < e; i++) {
            if (findParent(arr[i][0]) == findParent(arr[i][1])) {
                cycle = true;
                break;
            } else {
                unionParent(arr[i][0], arr[i][1]);
            }
        }
        System.out.println(cycle ? "사이클이 발생했습니다." : "사이클이 발생하지 않았습니다.");
    }
}
