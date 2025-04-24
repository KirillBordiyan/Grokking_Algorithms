package gb.pract.leetcode.med;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneratePar {
    public static void main(String[] args) {
        System.out.println(gen(3));
        System.out.println(gen(4));
        System.out.println(gen(5));
        System.out.println(gen(6));


        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(4));
        System.out.println(generateParenthesis(5));
        System.out.println(generateParenthesis(6));
    }


    public static List<String> gen(int n) {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));
        for( int i = 1; i <= n; i++){
            final List<String> list = new ArrayList<>();
            for(int j = 0; j<i; j++){
                for(final String first: lists.get(j)){
                    for(final String sec: lists.get(i-j-1)){
                        list.add("("+first+")" + sec);
                    }
                }
            }
            lists.add(list);
        }

        return lists.get(lists.size()-1);
    }

    public static List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();
        back(list, "", 0, 0, n);
        return list;

    }

    public static void back(List<String> list, String s, int open, int close, int max) {
        if (s.length() == max * 2) {
            list.add(s);
            return;
        }
        if (open < max) {
            back(list, s + "(", open + 1, close, max);
        }
        if (close < open) {
            back(list, s + ")", open, close + 1, max);
        }
    }
}
