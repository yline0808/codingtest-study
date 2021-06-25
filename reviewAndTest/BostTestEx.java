package reviewAndTest;

import java.util.Stack;

public class BostTestEx {
    public static int solutionRemove(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i))
                stack.pop();
            else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static int solutionStringZip(String s) {
        int answer = s.length();

        for (int i = 1; i < s.length() / 2 + 1; i++) {
            int zipLevel = 1;
            String zipStr = s.substring(0, i);
            String result = "";

            for (int j = i; j < s.length() + 1; j += i) {
                if (zipStr.equals(s.substring(j, (j + i > s.length() ? s.length() : j + i))))
                    zipLevel++;
                else {
                    result += (zipLevel == 1 ? "" : zipLevel) + zipStr;
                    zipStr = s.substring(j, (j + i > s.length() ? s.length() : j + i));
                    zipLevel = 1;
                }
            }
            result += zipStr;

            answer = Math.min(answer, result.length());
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("===01===");
        System.out.println(1);
        System.out.println(solutionRemove("baabaa"));
        System.out.println(0);
        System.out.println(solutionRemove("cdcd"));

        System.out.println("===02===");
        System.out.println(7);
        System.out.println(solutionStringZip("aabbaccc"));
        System.out.println(14);
        System.out.println(solutionStringZip("abcabcabcabcdededededede"));
        System.out.println(17);
        System.out.println(solutionStringZip("xababcdcdababcdcd"));
    }
}
