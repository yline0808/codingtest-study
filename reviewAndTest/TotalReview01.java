package reviewAndTest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

import mylib.MyLibs;

public class TotalReview01 {
    static int[] dx = { -1, 1, 0, 0, };
    static int[] dy = { 0, 0, 1, -1 };

    public static int solCoupleRemove(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c)
                stack.pop();
            else
                stack.push(c);
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static int solMoreHot(int[] scoville, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int scov : scoville)
            pq.offer(scov);

        while (pq.peek() < k) {
            if (pq.size() <= 1)
                return -1;
            pq.offer(pq.poll() + pq.poll() * 2);
            answer++;
        }
        return answer;
    }

    public static long solNormalSquare(int w, int h) {
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        return ((long) w * (long) h) - ((long) w / gcd + (long) h / gcd - 1) * gcd;
    }

    public static String sol124World(int n) {
        StringBuilder answer = new StringBuilder();
        String[] num = { "4", "1", "2" };

        while (n > 0) {
            answer.insert(0, num[n % 3]);
            n = (n - 1) / 3;
        }

        return answer.toString();
    }

    static class ColorNode {
        private int x;
        private int y;

        public ColorNode(int x, int y) {
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

    static int maxSize = 1;

    public static void colorBfs(int x, int y, int m, int n, Queue<ColorNode> q, int[][] picture, boolean[][] check) {
        check[y][x] = true;
        q.offer(new ColorNode(x, y));

        while (!q.isEmpty()) {
            ColorNode node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.getX() + dx[i];
                int ny = node.getY() + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !check[ny][nx] && picture[y][x] == picture[ny][nx]) {
                    maxSize++;
                    check[ny][nx] = true;
                    q.offer(new ColorNode(nx, ny));
                }
            }
        }
    }

    public static int[] solColoringBook(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] check = new boolean[m][n];
        Queue<ColorNode> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j] && picture[i][j] > 0) {
                    maxSize = 1;
                    colorBfs(j, i, m, n, q, picture, check);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, maxSize);
                    numberOfArea++;
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static int[] solFunctionDevelopment(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++)
            q.offer((100 - progresses[i]) % speeds[i] == 0 ? (100 - progresses[i]) / speeds[i]
                    : (100 - progresses[i]) / speeds[i] + 1);

        int now = q.poll();
        int endCnt = 1;
        while (!q.isEmpty()) {
            int next = q.poll();

            if (now >= next)
                endCnt++;
            else {
                answer.add(endCnt);
                endCnt = 1;
                now = next;
            }
        }
        answer.add(endCnt);

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static int solZipString(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            int zipLevel = 1;
            String zipStr = s.substring(0, i);
            StringBuilder result = new StringBuilder();

            for (int j = i; j <= s.length(); j += i) {
                if (zipStr.equals(s.substring(j, j + i >= s.length() ? s.length() : j + i))) {
                    zipLevel++;
                } else {
                    result.append((zipLevel == 1 ? "" : zipLevel) + zipStr);
                    zipStr = s.substring(j, j + i >= s.length() ? s.length() : j + i);
                    zipLevel = 1;
                }
            }
            result.append(zipStr);
            answer = Math.min(answer, result.length());
        }

        return answer;
    }

    static HashMap<Character, Integer> photoHm;
    static int photoAnswer;
    static boolean[] photoVisited;
    static int[] photoCh;

    public static boolean photocheck(String[] data) {
        int a, b, res;
        char op;

        for (String s : data) {
            a = photoCh[photoHm.get(s.charAt(0))];
            b = photoCh[photoHm.get(s.charAt(2))];
            op = s.charAt(3);
            res = s.charAt(4) - '0' + 1;

            switch (op) {
                case '=':
                    if (Math.abs(a - b) != res)
                        return false;
                    break;
                case '>':
                    if (Math.abs(a - b) <= res)
                        return false;
                    break;
                case '<':
                    if (Math.abs(a - b) >= res)
                        return false;
                    break;
            }
        }
        return true;
    }

    public static void photoDfs(int idx, String[] data) {
        if (idx == 8 && photocheck(data))
            photoAnswer++;
        else {
            for (int i = 0; i < 8; i++) {
                if (!photoVisited[i]) {
                    photoVisited[i] = true;
                    photoCh[idx] = i;
                    photoDfs(idx + 1, data);
                    photoVisited[i] = false;
                }
            }
        }
    }

    public static int solGroupPhoto(int n, String[] data) {
        photoAnswer = 0;
        photoHm = new HashMap<>();
        photoVisited = new boolean[8];
        photoCh = new int[8];

        photoHm.put('A', 0);
        photoHm.put('C', 1);
        photoHm.put('F', 2);
        photoHm.put('J', 3);
        photoHm.put('M', 4);
        photoHm.put('N', 5);
        photoHm.put('R', 6);
        photoHm.put('T', 7);

        photoDfs(0, data);

        return photoAnswer;
    }

    public static String[] solOpenChat(String[] record) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<String, String> hm = new HashMap<>();

        for (String str : record) {
            StringTokenizer st = new StringTokenizer(str);
            String comment = st.nextToken();
            String uid = st.nextToken();
            String name = comment.equals("Leave") ? "" : st.nextToken();

            switch (comment) {
                case "Enter":
                    hm.put(uid, name);
                    result.add(uid + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    result.add(uid + "님이 나갔습니다.");
                    break;
                case "Change":
                    hm.put(uid, name);
                    break;
            }
        }
        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            String uid = result.get(i).substring(0, result.get(i).indexOf("님"));
            answer[i] = result.get(i).replace(uid, hm.get(uid));
        }
        return answer;
    }

    public static int targetDfs(int[] numbers, int target, int idx, int num) {
        if (idx == numbers.length)
            return target == num ? 1 : 0;
        else
            return targetDfs(numbers, target, idx + 1, num - numbers[idx])
                    + targetDfs(numbers, target, idx + 1, num + numbers[idx]);
    }

    public static int solTargetNumber(int[] numbers, int target) {
        return targetDfs(numbers, target, 0, 0);
    }

    static class GameNode {
        private int x;
        private int y;

        public GameNode(int x, int y) {
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

    public static void gameBfs(int[][] maps, int x, int y) {
        Queue<GameNode> q = new LinkedList<>();
        q.offer(new GameNode(x, y));
        while (!q.isEmpty()) {
            GameNode node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.getX() + dx[i];
                int ny = node.getY() + dy[i];

                if (nx >= 0 && ny >= 0 && nx < maps[0].length && ny < maps.length && maps[ny][nx] == 1) {
                    maps[ny][nx] = maps[node.getY()][node.getX()] + 1;
                    q.offer(new GameNode(nx, ny));
                }
            }
        }
    }

    public static int solGameMapSortCut(int[][] maps) {
        gameBfs(maps, 0, 0);
        return maps[maps.length - 1][maps[0].length - 1] == 1 ? -1 : maps[maps.length - 1][maps[0].length - 1];
    }

    public static int solJoyStick(String name) {
        int answer = 0;
        int len = name.length();
        int min = len - 1;

        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            int mov = (c - 'A' < 'Z' - c + 1) ? (c - 'A') : ('Z' - c + 1);
            answer += mov;

            int nextIndex = i + 1;
            while (nextIndex < len && name.charAt(nextIndex) == 'A')
                nextIndex++;

            min = Math.min(min, i * 2 + len - nextIndex);
        }
        answer += min;

        return answer;
    }

    public static int solPredictionTable(int n, int a, int b) {
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

    public static boolean solPhoneList(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i]))
                return false;
        }

        return true;
    }

    public static boolean isPrimeNumber(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i <= (int) Math.sqrt(num); i++)
            if (num % i == 0)
                return false;
        return true;
    }

    public static void primeMake(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();

        if (!prefix.equals(""))
            set.add(Integer.parseInt(prefix));
        for (int i = 0; i < n; i++)
            primeMake(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
    }

    public static int solFindPrimeNumber(String numbers) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();

        primeMake("", numbers, set);

        while (set.iterator().hasNext()) {
            int a = set.iterator().next();
            set.remove(a);
            if (isPrimeNumber(a))
                answer++;
        }

        return answer;
    }

    public static String solBigNumber(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] num = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++)
            num[i] = Integer.toString(numbers[i]);

        Arrays.sort(num, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });

        for (String str : num)
            answer.append(str);

        return answer.toString();
    }

    public static int solPrinter(int[] priories, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int priority : priories)
            pq.offer(priority);

        while (!pq.isEmpty()) {
            for (int i = 0; i < priories.length; i++) {
                if (pq.peek() == priories[i]) {
                    pq.poll();
                    answer++;
                    if (location == i) {
                        pq.clear();
                        break;
                    }
                }
            }
        }

        return answer;
    }

    public static int solHIndex(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > answer) {
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }

    public static int solCamouflage(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();

        for (String[] cloth : clothes) {
            hm.put(cloth[1], hm.getOrDefault(cloth[1], 1) + 1);
        }

        for (int cnt : hm.values())
            answer *= cnt;

        return --answer;
    }

    static class DelivNode implements Comparable<DelivNode> {
        private int index;
        private int distance;

        public DelivNode(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return this.index;
        }

        public int getDistance() {
            return this.distance;
        }

        @Override
        public int compareTo(DelivNode other) {
            return this.distance < other.getDistance() ? -1 : 1;
        }
    }

    public static int solDelivery(int n, int[][] road, int k) {
        int answer = 0;
        int[] town = new int[n + 1];
        PriorityQueue<DelivNode> pq = new PriorityQueue<>();

        Arrays.fill(town, 500001);

        pq.offer(new DelivNode(1, 0));

        while (!pq.isEmpty()) {
            DelivNode node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();

            if (dist > town[now])
                continue;
            for (int i = 0; i < road.length; i++) {
                int cost, idx;
                if (road[i][0] == now) {
                    idx = road[i][1];
                    cost = dist + road[i][2];
                    if (cost < town[idx]) {
                        town[idx] = cost;
                        pq.offer(new DelivNode(idx, cost));
                    }
                } else if (road[i][1] == now) {
                    idx = road[i][0];
                    cost = dist + road[i][2];
                    if (cost < town[idx]) {
                        town[idx] = cost;
                        pq.offer(new DelivNode(idx, cost));
                    }
                }
            }
        }
        MyLibs.pList(town);
        for (int i = 1; i <= n; i++)
            answer += town[i] <= k ? 1 : 0;

        return answer;
    }

    public static void selectedSolPrinter(int sel) {
        switch (sel) {
            case 1:
                System.out.printf("===%d. 짝지어 제거하기===\n", sel);
                System.out.println(1);
                System.out.println(solCoupleRemove("baabaa"));
                System.out.println(0);
                System.out.println(solCoupleRemove("cdcd"));
                break;
            case 2:
                int[] scoville = { 1, 2, 3, 9, 10, 12 };
                System.out.printf("===%d. 더 맵게===\n", sel);
                System.out.println(2);
                System.out.println(solMoreHot(scoville, 7));
                break;
            case 3:
                System.out.printf("===%d. 멀쩡한 사각형 (안나올듯)===\n", sel);
                System.out.println(80);
                System.out.println(solNormalSquare(8, 12));
                break;
            case 4:
                System.out.printf("===%d. 124 나라의 숫자===\n", sel);
                System.out.println(4);
                System.out.println(sol124World(3));
                System.out.println(11);
                System.out.println(sol124World(4));
                break;
            case 5:
                int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
                        { 0, 0, 0, 3 } };
                System.out.printf("===%d. 카카오프렌즈 컬러링북===\n", sel);
                System.out.println("4\t5");
                MyLibs.pList(solColoringBook(6, 4, picture));
                break;
            case 6:
                int[] progresses1 = { 93, 30, 55 };
                int[] speeds1 = { 1, 30, 5 };
                int[] progresses2 = { 95, 90, 99, 99, 80, 99 };
                int[] speeds2 = { 1, 1, 1, 1, 1, 1 };
                System.out.printf("===%d. 기능개발===\n", sel);
                System.out.println("2\t1");
                MyLibs.pList(solFunctionDevelopment(progresses1, speeds1));
                System.out.println("1\t3\t2");
                MyLibs.pList(solFunctionDevelopment(progresses2, speeds2));
                break;
            case 7:
                System.out.printf("===%d. 문자열 압축===\n", sel);
                System.out.println(7);
                System.out.println(solZipString("aabbaccc"));
                System.out.println(9);
                System.out.println(solZipString("ababcdcdababcdcd"));
                System.out.println(8);
                System.out.println(solZipString("abcabcdede"));
                System.out.println(14);
                System.out.println(solZipString("abcabcabcabcdededededede"));
                System.out.println(17);
                System.out.println(solZipString("xababcdcdababcdcd"));
                break;
            case 8:
                String[] data1 = { "N~F=0", "R~T>2" };
                String[] data2 = { "M~C<2", "C~M>1" };
                System.out.printf("!!!===%d. 단체사진 찍기===\n", sel);
                System.out.println(3648);
                System.out.println(solGroupPhoto(2, data1));
                System.out.println(0);
                System.out.println(solGroupPhoto(2, data2));
                break;
            case 9:
                String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
                        "Change uid4567 Ryan" };
                String[] result = { "Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다." };
                System.out.printf("===%d. 오픈채팅방===\n", sel);
                MyLibs.pList(result);
                MyLibs.pList(solOpenChat(record));
                break;
            case 10:
                int[] numbers = { 1, 1, 1, 1, 1 };
                System.out.printf("===%d. 타겟 넘버===\n", sel);
                System.out.println(5);
                System.out.println(solTargetNumber(numbers, 3));
                break;
            case 11:
                int maps1[][] = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
                        { 0, 0, 0, 0, 1 } };
                int maps2[][] = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 1 } };
                System.out.printf("===%d. 게임 맵 최단거리===\n", sel);
                System.out.println(11);
                System.out.println(solGameMapSortCut(maps1));
                System.out.println(-1);
                System.out.println(solGameMapSortCut(maps2));
                break;
            case 12:
                System.out.printf("===%d. 조이스틱===\n", sel);
                System.out.println(56);
                System.out.println(solJoyStick("JEROEN"));
                System.out.println(23);
                System.out.println(solJoyStick("JAN"));
                break;
            case 13:
                System.out.printf("===%d. 예상 대진표===\n", sel);
                System.out.println(3);
                System.out.println(solPredictionTable(8, 4, 7));
                break;
            case 14:
                String[] phone_book1 = { "119", "97674223", "1195524421" };
                String[] phone_book2 = { "123", "456", "789" };
                String[] phone_book3 = { "12", "123", "1235", "567", "88" };
                System.out.printf("===%d. 전화번호 목록===\n", sel);
                System.out.println(false);
                System.out.println(solPhoneList(phone_book1));
                System.out.println(true);
                System.out.println(solPhoneList(phone_book2));
                System.out.println(false);
                System.out.println(solPhoneList(phone_book3));
                break;
            case 15:
                System.out.printf("===%d. 소수 찾기===\n", sel);
                System.out.println(3);
                System.out.println(solFindPrimeNumber("17"));
                System.out.println(2);
                System.out.println(solFindPrimeNumber("011"));
                break;
            case 16:
                int[] numbers1 = { 6, 10, 2 };
                int[] numbers2 = { 3, 30, 34, 5, 9 };
                System.out.printf("===%d. 가장 큰 수===\n", sel);
                System.out.println(6210);
                System.out.println(solBigNumber(numbers1));
                System.out.println(9534330);
                System.out.println(solBigNumber(numbers2));
                break;
            case 17:
                int[] priories1 = { 2, 1, 3, 2 };
                int[] priories2 = { 1, 1, 9, 1, 1, 1 };
                System.out.printf("===%d. 프린터===\n", sel);
                System.out.println(1);
                System.out.println(solPrinter(priories1, 2));
                System.out.println(5);
                System.out.println(solPrinter(priories2, 0));
                break;
            case 18:
                int[] citations = { 3, 0, 6, 1, 5 };
                System.out.printf("===%d. H-Index(안나올듯)===\n", sel);
                System.out.println(3);
                System.out.println(solHIndex(citations));
                break;
            case 19:
                String[][] clothes1 = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
                        { "green_turban", "headgear" } };
                String[][] clothes2 = { { "crowmask", "face" }, { "bluesunglasses", "face" },
                        { "smoky_makeup", "face" } };
                System.out.printf("===%d. 위장===\n", sel);
                System.out.println(5);
                System.out.println(solCamouflage(clothes1));
                System.out.println(3);
                System.out.println(solCamouflage(clothes2));
                break;
            case 20:
                int[][] road1 = { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1 }, { 5, 4, 2 } };
                int[][] road2 = { { 1, 2, 1 }, { 1, 3, 2 }, { 2, 3, 2 }, { 3, 4, 3 }, { 3, 5, 2 }, { 3, 5, 3 },
                        { 5, 6, 1 } };
                System.out.printf("===%d. 배달===\n", sel);
                System.out.println(4);
                System.out.println(solDelivery(5, road1, 3));
                System.out.println(4);
                System.out.println(solDelivery(6, road2, 4));
                break;
            case 21:
                System.out.printf("===%d. ===\n", sel);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 22:
                System.out.printf("===%d. ===\n", sel);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 23:
                System.out.printf("===%d. ===\n", sel);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 24:
                System.out.printf("===%d. ===\n", sel);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 25:
                System.out.printf("===%d. ===\n", sel);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 26:
                System.out.printf("===%d. ===\n", sel);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 27:
                System.out.printf("===%d. ===\n", sel);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 28:
                System.out.printf("===%d. ===\n", sel);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 29:
                System.out.printf("===%d. ===\n", sel);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 30:
                System.out.printf("===%d. ===\n", sel);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 31:
                System.out.printf("===%d. ===\n", sel);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 32:
                System.out.printf("===%d. ===\n", sel);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 33:
                System.out.printf("===%d. ===\n", sel);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 34:
                System.out.printf("===%d. ===\n", sel);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 35:
                System.out.printf("===%d. ===\n", sel);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 36:
                System.out.printf("===%d. ===\n", sel);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 37:
                System.out.printf("===%d. ===\n", sel);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 38:
                System.out.printf("===%d. ===\n", sel);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 39:
                System.out.printf("===%d. ===\n", sel);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 40:
                System.out.printf("===%d. ===\n", sel);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            default:
                System.out.println("===없는 번호입니다.===");
                break;
        }
    }

    public static void main(String[] artgs) {
        Scanner sc = new Scanner(System.in);
        System.out.print("실행할 문제 : ");
        selectedSolPrinter(sc.nextInt());
        sc.close();
    }
}
