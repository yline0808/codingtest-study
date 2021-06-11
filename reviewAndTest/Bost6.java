package reviewAndTest;

import java.util.ArrayList;
import java.util.Arrays;

public class Bost6 {
    public static ArrayList<Integer> sol(ArrayList<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] check = new int[101];

        for (int i = 0; i < check.length; i++) {
            for (int j = 0; j < arr.size(); j++) {
                if (i == arr.get(j))
                    check[i]++;
            }
        }

        for (int i = 1; i < arr.size(); i++) {
            if (check[i] > 1)
                result.add(check[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(
                Arrays.asList(new ArrayList<>(Arrays.asList(1, 2, 3, 3, 3, 3, 4, 4)),
                        new ArrayList<>(Arrays.asList(3, 2, 4, 4, 2, 5, 2, 5, 5)),
                        new ArrayList<>(Arrays.asList(3, 5, 7, 9, 1))));

        for (int i = 0; i < arr.size(); i++) {
            ArrayList<Integer> result = sol(arr.get(i));
            System.out.println(result.size() != 0 ? result.toString() : -1);
        }
    }
}
