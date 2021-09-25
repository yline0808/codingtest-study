package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

import mylib.MyLibs;

/*
 * 문제 : [3차] 파일명 정렬
 * url : https://programmers.co.kr/learn/courses/30/lessons/17686
 * 유형 : 2018 KAKAO BLIND RECRUITMENT
 */

public class FileSort {
    public static void main(String[] args) {
        String[] files1 = { "img12.png", "img12.txt", "img12.pnge", "img12.pnfg" };
        MyLibs.pList(solution(files1));

        // String[] files1 = { "img12.png", "img10.png", "img02.png", "img1.png",
        // "IMG01.GIF", "img2.JPG" };
        // String[] result1 = { "img1.png", "IMG01.GIF", "img02.png", "img2.JPG",
        // "img10.png", "img12.png" };
        // String[] files2 = { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10
        // Thunderbolt II", "F-14 Tomcat" };
        // String[] result2 = { "A-10 Thunderbolt II", "B-50 Superfortress", "F-5
        // Freedom Fighter", "F-14 Tomcat" };

        // MyLibs.pList(result1);
        // MyLibs.pList(solution(files1));
        // MyLibs.pList(result2);
        // MyLibs.pList(solution(files2));
    }

    public static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String head1 = s1.split("[0-9]")[0];
                String head2 = s2.split("[0-9]")[0];
                System.out.println(head1);
                int compareHead = head1.toUpperCase().compareTo(head2.toUpperCase());

                return compareHead == 0
                        ? getNumber(s1.substring(head1.length())) - getNumber(s2.substring(head2.length()))
                        : compareHead;
            }
        });

        return files;
    }

    public static int getNumber(String str) {
        StringBuilder num = new StringBuilder();
        for (char c : str.toCharArray())
            if (Character.isDigit(c) && num.length() < 5)
                num.append(c);
            else
                break;
        return Integer.parseInt(num.toString());
    }
}
