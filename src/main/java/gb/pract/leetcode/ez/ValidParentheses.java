package gb.pract.leetcode.ez;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("})"));
        System.out.println(isValid("(})"));
        System.out.println(isValid("(){}[]"));
        System.out.println(isValid("({})"));
        System.out.println(isValid(")"));
        System.out.println(isValid("(())"));
    }

    /*
     * -открыт-закрыт в такой же последовательности
     * -если открыт, должна быть закрыта
     * -если закрыта, должна была быть открытая
     *
     * */
    public static boolean isValid(String s) {
        Deque<String> q = new ArrayDeque<>();

        String[] split = s.split("");
        String dbr = "(";
        String qbr = "[";
        String fbr = "{";

        if (split.length == 1) {
            return false;
        }

        for (String string : split) {

            if (string.equals("(") || string.equals("[") || string.equals("{")) {
                q.addFirst(string);
            } else if (q.isEmpty()) {
                if (string.equals(")") || string.equals("]") || string.equals("}")) {
                    return false;
                }
            } else {
                if (q.getFirst().equals(dbr)) {
                    if (string.equals(")")) {
                        q.pop();
                        continue;
                    }
                    return false;
                }
                if (q.getFirst().equals(qbr)) {
                    if (string.equals("]")) {
                        q.pop();
                        continue;
                    }
                    return false;
                }
                if (q.getFirst().equals(fbr)) {
                    if (string.equals("}")) {
                        q.pop();
                        continue;
                    }
                    return false;
                }
            }
        }
        return q.isEmpty();
    }
}


