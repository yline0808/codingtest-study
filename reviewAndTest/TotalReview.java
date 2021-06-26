package reviewAndTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import mylib.MyLibs;

class GameMapNode {
    private int x;
    private int y;

    public GameMapNode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class TotalReview {
    public static int solRemoe(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.size() > 0 && stack.peek().equals(s.charAt(i)))
                stack.pop();
            else
                stack.push(s.charAt(i));
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static int solZipStr(String s) {
        int answer = s.length();

        for (int i = 1; i < s.length() / 2 + 1; i++) {
            int zipLevel = 1;
            String zipStr = s.substring(0, i);
            String resultStr = "";

            for (int j = i; j <= s.length(); j += i) {
                if (zipStr.equals(s.substring(j, j + i > s.length() ? s.length() : j + i)))
                    zipLevel++;
                else {
                    resultStr += (zipLevel == 1 ? "" : zipLevel) + zipStr;
                    zipLevel = 1;
                    zipStr = s.substring(j, j + i > s.length() ? s.length() : j + i);
                }
            }
            resultStr += zipStr;
            answer = Math.min(answer, resultStr.length());
        }

        return answer;
    }

    public static String sol124Num(int n) {
        String answer = "";
        String[] numbers = { "4", "1", "2" };

        while (n > 0) {
            answer = numbers[n % 3] + answer;
            n = (n - 1) / 3;
        }

        return answer;
    }

    public static int solScoville(int[] scoville, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int scov : scoville) {
            pq.offer(scov);
        }

        while (pq.peek() < k) {
            if (pq.size() <= 1)
                return -1;
            pq.add(pq.poll() + pq.poll() * 2);
            answer++;
        }

        return answer;
    }

    public static int solTargetNum(int[] numbers, int target) {
        return dfsTargetNum(numbers, target, 0, 0);
    }

    public static int dfsTargetNum(int[] numbers, int target, int index, int num) {
        if (index == numbers.length)
            return target == num ? 1 : 0;
        else
            return dfsTargetNum(numbers, target, index + 1, num + numbers[index])
                    + dfsTargetNum(numbers, target, index + 1, num - numbers[index]);
    }

    public static int[] solFunctionDevelopment(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            q.offer((100 - progresses[i]) % speeds[i] == 0 ? (100 - progresses[i]) / speeds[i]
                    : (100 - progresses[i]) / speeds[i] + 1);
        }

        int start = q.poll();
        int day = 1;
        ArrayList<Integer> answer = new ArrayList<>();
        while (!q.isEmpty()) {
            int next = q.poll();
            if (start >= next)
                day++;
            else {
                answer.add(day);
                day = 1;
                start = next;
            }
        }
        answer.add(day);
        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static int solPlayTable(int n, int a, int b) {
        int answer = 1;
        int left = Math.min(a, b);
        int right = Math.max(a, b);

        while (left % 2 == 0 || right - left != 1) {
            left = (left + 1) / 2;
            right = (right + 1) / 2;
            answer++;
        }
        return answer;
    }

    public static int solGameMap(int[][] maps) {
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        Queue<GameMapNode> q = new LinkedList<>();
        int x = 0;
        int y = 0;

        q.offer(new GameMapNode(x, y));
        while (!q.isEmpty()) {
            GameMapNode node = q.poll();
            x = node.getX();
            y = node.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= maps[0].length || ny >= maps.length || maps[ny][nx] == 0)
                    continue;
                if (maps[ny][nx] == 1) {
                    maps[ny][nx] = maps[y][x] + 1;
                    q.offer(new GameMapNode(nx, ny));
                }
            }
        }

        return maps[maps.length - 1][maps[0].length - 1] == 1 ? -1 : maps[maps.length - 1][maps[0].length - 1];
    }

    public static int solQueuePrinter(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int priority : priorities)
            pq.offer(priority);

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;

                    if (i == location) {
                        pq.clear();
                        break;
                    }
                }
            }
        }

        return answer;
    }

    public static boolean solPhoneNumList(String[] phoneBook) {
        Arrays.sort(phoneBook);
        for (int i = 0; i < phoneBook.length - 1; i++)
            if (phoneBook[i + 1].startsWith(phoneBook[i]))
                return false;
        return true;
    }

    public static String solBigNum(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++)
            arr[i] = Integer.toString(numbers[i]);

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });

        if (arr[0].equals("0"))
            return "0";

        for (String n : arr)
            answer += n;

        return answer;
    }

    public static int solJoyStick(String name) {
        int answer = 0;
        int len = name.length();
        int min = len - 1;

        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            int mov = c - 'A' < 'Z' - c + 1 ? c - 'A' : 'Z' - c + 1;
            answer += mov;

            int nextIndex = i + 1;

            while (nextIndex < len && name.charAt(nextIndex) == 'A')
                nextIndex++;

            min = Math.min(min, (i * 2) + len - nextIndex);
        }

        return answer + min;
    }

    public static int[] solStock(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j])
                    answer[i]++;
                else {
                    answer[i]++;
                    break;
                }
            }
        }

        return answer;
    }

    public static int solBigSquare(int[][] board) {
        int answer = 0;

        if (board.length == 1 || board[0].length == 1)
            return 1;

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] != 0)
                    board[i][j] = Math.min(board[i][j - 1], Math.min(board[i - 1][j - 1], board[i - 1][j])) + 1;
                answer = Math.max(answer, board[i][j]);
            }
        }

        return (int) Math.pow(answer, 2);
    }

    public static boolean solFitBracket(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == ')')
                stack.pop();
            else
                stack.push(s.charAt(i));
        }

        return stack.isEmpty();
    }

    public static String solNnumGame(int n, int t, int m, int p) {
        String answer = "";
        String totalNumber = "";
        int number = 0;

        while (totalNumber.length() < m * t)
            totalNumber += Integer.toString(number++, n).toUpperCase();

        for (int i = 0; i < t; i++)
            answer += totalNumber.charAt(i * m + p - 1);

        return answer;
    }

    public static int solNextBigNum(int n) {
        int answer = 0;
        int oneCnt = nextBigNumOneCnt(Integer.toBinaryString(n));
        while (answer == 0) {
            answer = nextBigNumOneCnt(Integer.toBinaryString(++n)) == oneCnt ? n : 0;
        }

        return answer;
    }

    public static int nextBigNumOneCnt(String binaryStr) {
        int cnt = 0;
        for (int i = 0; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i) == '1')
                cnt++;
        }
        return cnt;
    }

    public static int solGetLand(int[][] land) {
        int answer = 0;

        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }

        for (int i = 0; i < 4; i++)
            answer = Math.max(answer, land[land.length - 1][i]);

        return answer;
    }

    public static int solNumExpression(int n) {
        int answer = 1;

        for (int i = 1; i <= n / 2; i++) {
            int num = 0;
            int j = i;
            while (n > num) {
                num += j++;
            }
            answer += n == num ? 1 : 0;
        }

        return answer;
    }

    public static String solMaxMinNum(String s) {
        ArrayList<Integer> list = new ArrayList<>();

        for (String num : s.split(" "))
            list.add(Integer.parseInt(num));

        Collections.sort(list);

        return list.get(0) + " " + list.get(list.size() - 1);
    }

    public static int solMakeMinNum(int[] a, int[] b) {
        int answer = 0;

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++)
            answer += a[i] * b[a.length - 1 - i];

        return answer;
    }

    public static int solFibonacci(int n) {
        if (n < 2)
            return 1;

        int[] answer = new int[n];
        answer[0] = answer[1] = 1;

        for (int i = 2; i < n; i++)
            answer[i] = answer[i - 2] + answer[i - 1];

        return answer[n - 1];
    }

    public static int[][] solMatrixMultiply(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                for (int k = 0; k < arr2[0].length; k++) {
                    answer[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }

        return answer;
    }

    public static String solJadenCase(String s) {
        StringBuilder answer = new StringBuilder(Character.toString(s.charAt(0)).toUpperCase());

        for (int i = 1; i < s.length(); i++)
            answer.append(s.charAt(i - 1) == ' ' ? Character.toString(s.charAt(i)).toUpperCase()
                    : Character.toString(s.charAt(i)).toLowerCase());

        return answer.toString();
    }

    public static int solNrcm(int[] arr) {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++)
            answer = nLCM(answer, arr[i]);

        return answer;
    }

    // 최소 공배수 - a*b / 최대공약수
    public static int nLCM(int a, int b) {
        return a * b / nGCD(a, b);
    }

    // 최대 공약수
    public static int nGCD(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (b == 0)
            return a;
        else
            return nGCD(b, a % b);
    }

    public static void solPrinter(int n) {
        switch (n) {
            case 1:
                System.out.println("===1. 짝지어 제거하기===");
                System.out.println(1);
                System.out.println(solRemoe("baabaa"));
                System.out.println(0);
                System.out.println(solRemoe("cdcd"));
                System.out.println();
                break;
            case 2:
                System.out.println("===2. 문자열 압축===");
                System.out.println(7);
                System.out.println(solZipStr("aabbaccc"));
                System.out.println(17);
                System.out.println(solZipStr("xababcdcdababcdcd"));
                System.out.println();
                break;
            case 3:
                System.out.println("===3. 124 나라의 숫자===");
                System.out.println(4);
                System.out.println(sol124Num(3));
                System.out.println(11);
                System.out.println(sol124Num(4));
                System.out.println();
                break;
            case 4:
                int[] scoville = { 1, 2, 3, 9, 10, 12 };
                System.out.println("===4. 더 맵게===");
                System.out.println(2);
                System.out.println(solScoville(scoville, 7));
                System.out.println();
                break;
            case 5:
                int[] numbers = { 1, 1, 1, 1, 1 };
                System.out.println("===5. 타겟 넘버===");
                System.out.println(5);
                System.out.println(solTargetNum(numbers, 3));
                System.out.println();
                break;
            case 6:
                int[] progresses1 = { 93, 30, 55 };
                int[] progresses2 = { 95, 90, 99, 99, 80, 99 };
                int[] speeds1 = { 1, 30, 5 };
                int[] speeds2 = { 1, 1, 1, 1, 1, 1 };
                System.out.println("===6. 기능개발===");
                System.out.println("2\t1");
                MyLibs.pList(solFunctionDevelopment(progresses1, speeds1));
                System.out.println("1\t3\t2");
                MyLibs.pList(solFunctionDevelopment(progresses2, speeds2));
                System.out.println();
                break;
            case 7:
                System.out.println("===7. 예상 대진표===");
                System.out.println(3);
                System.out.println(solPlayTable(8, 4, 7));
                System.out.println();
                break;
            case 8:
                int[][] maps1 = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
                        { 0, 0, 0, 0, 1 } };
                int[][] maps2 = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 1 } };
                System.out.println("===8. 게임 맵 최단거리===");
                System.out.println(11);
                System.out.println(solGameMap(maps1));
                System.out.println(-1);
                System.out.println(solGameMap(maps2));
                System.out.println();
                break;
            case 9:
                int[] priorities1 = { 2, 1, 3, 2 };
                int[] priorities2 = { 1, 1, 9, 1, 1, 1 };
                System.out.println("===9. 프린터===");
                System.out.println(1);
                System.out.println(solQueuePrinter(priorities1, 2));
                System.out.println(5);
                System.out.println(solQueuePrinter(priorities2, 0));
                System.out.println();
                break;
            case 10:
                String[] phoneBook1 = { "119", "97674223", "1195524421" };
                String[] phoneBook2 = { "123", "456", "789" };
                String[] phoneBook3 = { "12", "123", "1235", "567", "88" };
                System.out.println("===10. 전화번호 목록===");
                System.out.println(false);
                System.out.println(solPhoneNumList(phoneBook1));
                System.out.println(true);
                System.out.println(solPhoneNumList(phoneBook2));
                System.out.println(false);
                System.out.println(solPhoneNumList(phoneBook3));
                System.out.println();
                break;
            case 11:
                int[] numbers1 = { 6, 10, 2 };
                int[] numbers2 = { 3, 30, 34, 5, 9 };
                System.out.println("===11. 가장 큰 수===");
                System.out.println(6210);
                System.out.println(solBigNum(numbers1));
                System.out.println(9534330);
                System.out.println(solBigNum(numbers2));
                System.out.println();
                break;
            case 12:
                System.out.println("===12. 조이스틱===");
                System.out.println(56);
                System.out.println(solJoyStick("JEROEN"));
                System.out.println(23);
                System.out.println(solJoyStick("JAN"));
                System.out.println();
                break;
            case 13:
                int[] prices = { 1, 2, 3, 2, 3 };
                System.out.println("===13. 주식가격===");
                System.out.println("4\t3\t1\t1\t0");
                MyLibs.pList(solStock(prices));
                System.out.println();
                break;
            case 14:
                int[][] board1 = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };
                int[][] board2 = { { 0, 0, 1, 1 }, { 1, 1, 1, 1 } };
                System.out.println("===14. 가장 큰 정사각형 찾기===");
                System.out.println(9);
                System.out.println(solBigSquare(board1));
                System.out.println(4);
                System.out.println(solBigSquare(board2));
                System.out.println();
                break;
            case 15:
                System.out.println("===15. 올바른 괄호===");
                System.out.println(true);
                System.out.println(solFitBracket("()()"));
                System.out.println(true);
                System.out.println(solFitBracket("(())()"));
                System.out.println(false);
                System.out.println(solFitBracket(")()("));
                System.out.println(false);
                System.out.println(solFitBracket("(()("));
                System.out.println();
                break;
            case 16:
                System.out.println("===16. n진수 게임===");
                System.out.println("0111");
                System.out.println(solNnumGame(2, 4, 2, 1));
                System.out.println("02468ACE11111111");
                System.out.println(solNnumGame(16, 16, 2, 1));
                System.out.println("13579BDF01234567");
                System.out.println(solNnumGame(16, 16, 2, 2));
                System.out.println();
                break;
            case 17:
                System.out.println("===17. 다음 큰 숫자===");
                System.out.println(83);
                System.out.println(solNextBigNum(78));
                System.out.println(23);
                System.out.println(solNextBigNum(15));
                System.out.println();
                break;
            case 18:
                int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
                System.out.println("===18. 땅따먹기===");
                System.out.println(16);
                System.out.println(solGetLand(land));
                System.out.println();
                break;
            case 19:
                System.out.println("===19. 숫자의 표현===");
                System.out.println(4);
                System.out.println(solNumExpression(15));
                System.out.println();
                break;
            case 20:
                System.out.println("===20. 최댓값과 최솟값===");
                System.out.println("1 4");
                System.out.println(solMaxMinNum("1 2 3 4"));
                System.out.println("-4 -1");
                System.out.println(solMaxMinNum("-1 -2 -3 -4"));
                System.out.println("-1 -1");
                System.out.println(solMaxMinNum("-1 -1"));
                System.out.println();
                break;
            case 21:
                int[] a1 = { 1, 4, 2 };
                int[] b1 = { 5, 4, 4 };
                int[] a2 = { 1, 2 };
                int[] b2 = { 3, 4 };
                System.out.println("===21. 최솟값 만들기===");
                System.out.println(29);
                System.out.println(solMakeMinNum(a1, b1));
                System.out.println(10);
                System.out.println(solMakeMinNum(a2, b2));
                System.out.println();
                break;
            case 22:
                System.out.println("===22. 피보나치 수===");
                System.out.println(2);
                System.out.println(solFibonacci(3));
                System.out.println(5);
                System.out.println(solFibonacci(5));
                System.out.println();
                break;
            case 23:
                int[][] arr1 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
                int[][] arr2 = { { 3, 3 }, { 3, 3 } };
                int[][] result1 = { { 15, 15 }, { 15, 15 }, { 15, 15 } };
                int[][] arr3 = { { 2, 3, 2 }, { 4, 2, 4 }, { 3, 1, 4 } };
                int[][] arr4 = { { 5, 4, 3 }, { 2, 4, 1 }, { 3, 1, 1 } };
                int[][] result2 = { { 22, 22, 11 }, { 36, 28, 18 }, { 29, 20, 14 } };
                System.out.println("===23. 행렬의 곱셈===");
                MyLibs.pList(result1);
                System.out.println();
                MyLibs.pList(solMatrixMultiply(arr1, arr2));
                System.out.println();
                MyLibs.pList(result2);
                System.out.println();
                MyLibs.pList(solMatrixMultiply(arr3, arr4));
                System.out.println();
                break;
            case 24:
                System.out.println("===24. JadenCase 문자열 만들기===");
                System.out.println("3people Unfollowed Me");
                System.out.println(solJadenCase("3people unFollowed me"));
                System.out.println("For The Last Week");
                System.out.println(solJadenCase("for the last week"));
                System.out.println();
                break;
            case 25:
                int[] arr5 = { 2, 6, 8, 14 };
                int[] arr6 = { 1, 2, 3 };
                System.out.println("===25. N개의 최소공배수===");
                System.out.println(168);
                System.out.println(solNrcm(arr5));
                System.out.println(6);
                System.out.println(solNrcm(arr6));
                System.out.println();
                break;
            case 26:
                System.out.println("===26. ===");
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 27:
                System.out.println("===27. ===");
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 28:
                System.out.println("===28. ===");
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 29:
                System.out.println("===29. ===");
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 30:
                System.out.println("===30. ===");
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            default:
                System.out.println("===not exist===");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("실행할 문제 번호 : ");
        solPrinter(sc.nextInt());
        sc.close();
    }
}
