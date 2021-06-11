package chapter10;

public class Test01_cow2 {
    public static int v, e;
    public static int[] parent = new int[100001];

    public static int findParent(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    public static void main(String[] args) {
        v = 6;
        e = 4;
        int[][] arr = { { 1, 4 }, { 2, 3 }, { 2, 4 }, { 5, 6 } };

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            unionParent(arr[i][0], arr[i][1]);
        }
        System.out.println("각 원소가 속한 집합");
        for (int i = 1; i <= v; i++) {
            System.out.print(findParent(i) + " ");
        }
        System.out.println();

        System.out.println("부모 테이블");
        for (int i = 1; i <= v; i++) {
            System.out.print(parent[i] + " ");
        }
    }
}
