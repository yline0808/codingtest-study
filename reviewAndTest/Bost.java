package reviewAndTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import mylib.MyLibs;

/*
 * Bost6.java 파일이 더 좋은코드 인듯
 * 이건 내가 한거
 */

public class Bost {
    public static ArrayList<Integer> cntArr(ArrayList<Integer> arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.size(); i++) {
            if (!hashMap.containsKey(arr.get(i))) {
                hashMap.put(arr.get(i), 1);
            } else {
                hashMap.put(arr.get(i), hashMap.get(arr.get(i)) + 1);
            }
        }
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(-1));
        for (int value : hashMap.values()) {
            if (value != 1) {
                if (result.get(0) == -1) {
                    result = new ArrayList<>();
                }
                result.add(value);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrList = new ArrayList<>(
                Arrays.asList(new ArrayList<>(Arrays.asList(1, 2, 3, 3, 3, 3, 4, 4)),
                        new ArrayList<>(Arrays.asList(3, 2, 4, 4, 2, 5, 2, 5, 5)),
                        new ArrayList<>(Arrays.asList(3, 5, 7, 9, 1))));

        long startTime = System.currentTimeMillis();
        for (ArrayList<Integer> arr : arrList) {
            System.out.println(cntArr(arr).toString());
        }
        long endTime = System.currentTimeMillis();

        MyLibs.pResult(startTime, endTime, 0);
    }
}
