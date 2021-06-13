package programmers.level2;

import java.util.Arrays;

/*
 * 문제 : 전화번호 목록
 * url : https://programmers.co.kr/learn/courses/30/lessons/42577
 * 유형 : 해시
 */

public class PhoneNumList {
    public static void main(String[] args) {
        String[] phoneBook = { "12", "123", "1235", "567", "88" };
        System.out.println(solution(phoneBook));
    }

    public static boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        for (int i = 0; i < phoneBook.length - 1; i++) {
            if (phoneBook[i + 1].startsWith(phoneBook[i]))
                return false;
        }
        return true;
    }
}
