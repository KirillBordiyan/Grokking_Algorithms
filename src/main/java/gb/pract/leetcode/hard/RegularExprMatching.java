package gb.pract.leetcode.hard;

public class RegularExprMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("aa","a"));
        System.out.println(isMatch("aa","a*"));
        System.out.println(isMatch("ab",".*"));
    }


    public static boolean isMatch(String s, String p) {
        return s.matches(p);
    }
}
