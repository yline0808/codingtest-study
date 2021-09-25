package reviewAndTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import mylib.MyLibs;

public class TestCode {
    public static int[] solution(int[][] v) {
        int[] answer = new int[2];

        for (int j = 0; j < 2; j++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < v.length; i++) {
                if (arr.indexOf(v[i][j]) != -1) {
                    arr.remove(arr.indexOf(v[i][j]));
                } else {
                    arr.add(v[i][j]);
                }
                System.out.println(arr.toString());
            }
            answer[j] = arr.get(0);
        }

        return answer;
    }

    public static void test01() {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("t", 1);
        hm.put("e", 2);
        hm.put("s", 3);
        hm.put("y", 4);

        for (HashMap.Entry<String, Integer> entry : hm.entrySet()) {
            System.out.println(entry.toString());
        }
    }

    public static void test02() {
        for (int i = 0; i <= 9; ++i) {
            System.out.print(i);
        }
        System.out.println();
        for (int i = 0; i <= 9; i++) {
            System.out.print(i);
        }
    }

    public static void test03() {
        HashMap<Integer, String> hm = new HashMap<>();

        for (int i = 65; i < 91; i++) {
            hm.put(i - 64, (char) i + "");
        }
        for (HashMap.Entry<Integer, String> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + "|||" + entry.getValue());
        }
    }

    public static void test04() {
        ArrayList<String> strarr = new ArrayList<>();
        ArrayList<ArrayList<String>> arr = new ArrayList<>();
        strarr.add("a");
        strarr.add("b");
        strarr.add("c");
        strarr.add("d");

        strarr.remove("a.");

        System.out.println(strarr.toString());
    }

    public static void test05() {
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            hm.put((char) i + "", i - 'A' + 1);
        }

        for (HashMap.Entry<String, Integer> set : hm.entrySet()) {
            System.out.println(set);
        }
    }

    public static void main(String[] args) {
        // int[][] v = { { 1, 4 }, { 3, 4 }, { 3, 10 } };
        // int[][] v = { { 1, 1 }, { 2, 2 }, { 1, 2 } };

        // System.out.println("1\t10");
        // MyLibs.pList(solution(v));
        // test01();
        // test02();
        // test03();
        // test04();
        test05();
    }
}
