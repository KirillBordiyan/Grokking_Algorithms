package gb.pract.leetcode.med;

import java.util.Map;

public class LongestPalindromeSubs {
    public static void main(String[] args) {
        System.out.println(longest("abba"));
        System.out.println(longest("babad"));
        System.out.println(longest("abc"));
        System.out.println(longest("bdffiii"));
        System.out.println(longest("qweewq"));
    }

    public static String longest(String s){

        if(s == null || s.length() < 1){
            return "";
        }

        int left = 0;
        int right = 0;

        for(int i = 0; i < s.length(); i++){
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);

            int maxLen = Math.max(len1, len2); //2

            if(maxLen > right - left){
                left = i - ((maxLen-1)/2); //0-(2-1/2) //1
                right = i + (maxLen/2); // 0+2/2 //1
            }
        }

        return s.substring(left, right+1);
    }


    public static int expand(String s, int left, int right){

        if(s == null || left > right){
            return 0;
        }

        while(left >= 0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;
    }
}
