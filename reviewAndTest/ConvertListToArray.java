package reviewAndTest;

import java.util.ArrayList;
import java.util.Random;

import mylib.MyLibs;

/*
 * 결론 : mapToInt보다 하나씩 넣는게 2배 빠름
 */

public class ConvertListToArray {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        int size = (int) 1e8;
        long startTime;
        long endTime;

        int[] arr = new int[size];

        startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(r.nextInt(size));
        }
        endTime = System.currentTimeMillis();
        MyLibs.pResult(startTime, endTime, 1);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = list.get(i);
        }
        endTime = System.currentTimeMillis();
        MyLibs.pResult(startTime, endTime, 2);

        startTime = System.currentTimeMillis();
        arr = list.stream().mapToInt(i -> i).toArray();
        endTime = System.currentTimeMillis();
        MyLibs.pResult(startTime, endTime, 3);
    }
}
