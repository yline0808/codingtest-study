package reviewAndTest;

public class Ice01 {
    public static int row = 15, col = 14;
    public static int[][] arr = { { 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0 },
            { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0 }, { 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0 },
            { 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 }, { 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 },
            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 },
            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1 },
            { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 } };

    public static boolean dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= col || y >= row)
            return false;
        if (arr[y][x] == 0) {
            arr[y][x] = 1;
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);

            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int answer = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(j, i))
                    answer++;
            }
        }

        System.out.println(8);
        System.out.println(answer);
    }
}
