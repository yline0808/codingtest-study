package reviewAndTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Bost01 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(
                Arrays.asList(new ArrayList<>(Arrays.asList(1, 2, 3, 3, 3, 3, 4, 4)),
                        new ArrayList<>(Arrays.asList(3, 2, 4, 4, 2, 5, 2, 5, 5)),
                        new ArrayList<>(Arrays.asList(3, 5, 7, 9, 1))));

        for (ArrayList<Integer> l : list) {
            solution(l);
        }
    }

    public static void solution(ArrayList<Integer> list) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for (int num : list) {
            hm.put(num, hm.containsKey(num) ? hm.get(num) + 1 : 1);
        }
        for (int num : hm.values())
            if (num > 1)
                answer.add(num);

        if (answer.size() == 0)
            answer.add(-1);

        System.out.println(answer.toString());
    }
}
