package programmers.level1;

import java.util.HashMap;

public class Marathon {
    public static void main(String[] args) {
        String[] participant = { "mislav", "stanko", "mislav", "ana" };
        String[] completion = { "stanko", "ana", "mislav" };
        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();

        for (String name : participant)
            hm.put(name, hm.getOrDefault(name, 0) + 1);
        for (String name : completion)
            hm.put(name, hm.get(name) - 1);
        for (HashMap.Entry<String, Integer> entry : hm.entrySet())
            if (entry.getValue() != 0)
                return entry.getKey();

        return "";
    }
}
