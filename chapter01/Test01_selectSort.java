package chapter01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test01_selectSort {
    public static void main(String[] args) {
        int arrSize = 10000;
        Random random = new Random();
        ArrayList<Integer> array = new ArrayList<Integer>();

        // 선택정렬 구현
        for (int i = 0; i < arrSize; i++) {
            array.add(random.nextInt(100) + 1);
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < array.size(); i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.size(); j++) {
                if ((int) array.get(minIdx) > (int) array.get(j)) {
                    minIdx = j;
                }
            }
            int tmp = (int) array.get(minIdx);
            array.set(minIdx, array.get(i));
            array.set(i, tmp);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("total time : " + (endTime - startTime) / 1000.0);

        // 기본 정렬
        ArrayList<Integer> array2 = new ArrayList<Integer>();

        for (int i = 0; i < arrSize; i++) {
            array2.add(random.nextInt(100) + 1);
        }

        startTime = System.currentTimeMillis();

        Collections.sort(array2);

        endTime = System.currentTimeMillis();
        System.out.println("total time : " + (endTime - startTime) / 1000.0);
    }
}