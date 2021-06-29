package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import mylib.MyLibs;

/*
 * 문제 : 오픈채팅방
 * url : https://programmers.co.kr/learn/courses/30/lessons/42888
 * 유형 : 2019 KAKAO BLIND RECRUITMENT
 */

public class OpenChat {
    public static void main(String[] args) {
        String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
                "Change uid4567 Ryan" };
        String[] result = { "Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다." };
        MyLibs.pList(result);
        MyLibs.pList(solution(record));
    }

    public static String[] solution(String[] record) {
        HashMap<String, String> hm = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();

        for (String str : record) {
            StringTokenizer st = new StringTokenizer(str);
            String comment = st.nextToken();
            String uid = st.nextToken();
            String name = comment.equals("Leave") ? "" : st.nextToken();

            switch (comment) {
                case "Enter":
                    hm.put(uid, name);
                    arr.add(uid + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    arr.add(uid + "님이 나갔습니다.");
                    break;
                case "Change":
                    hm.put(uid, name);
                    break;
            }
        }

        String[] answer = new String[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            String uid = arr.get(i).substring(0, arr.get(i).indexOf("님"));
            answer[i] = arr.get(i).replace(uid, hm.get(uid));
        }

        return answer;
    }
}
