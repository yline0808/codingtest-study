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
