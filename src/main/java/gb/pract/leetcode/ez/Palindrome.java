package gb.pract.leetcode.ez;

import java.util.Objects;

public class Palindrome {
    public static void main(String[] args){
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(122));
        System.out.println(isPalindrome(11));
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(1211));
    }

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        String[] split = s.split("");
        int left=0, right=split.length-1;
        boolean pal = false;
        if(left == right){
            pal = true;
            return pal;
        }
        while(left < right){
            if(Objects.equals(split[left], split[right])){
                pal = true;
                left++;
                right--;
            } else {
                pal = false;
                return pal;
            }

        }
        return pal;

    }
}
