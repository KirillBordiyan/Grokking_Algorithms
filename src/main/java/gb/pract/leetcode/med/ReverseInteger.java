package gb.pract.leetcode.med;

import java.util.Arrays;

public class ReverseInteger {
    public static void main(String[] args) {

        System.out.println(rev(123));
        System.out.println(rev(1534236469));
        System.out.println(rev(-2));
        System.out.println(rev(2));
        System.out.println(rev(1));
        System.out.println(rev(-123));
        System.out.println(rev(120));
        System.out.println();

        System.out.println(reverse(1534236469));
        System.out.println(reverse(-2));
        System.out.println(reverse(2));
        System.out.println(reverse(1));
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }


    public static int rev(int x){
        if(x >= -9 && x <= 9){
            return x;
        }
        boolean isNegative = x < 0;
        x = Math.abs(x);

        StringBuilder split = new StringBuilder(String.valueOf(x));
        int left = 0;
        int right = split.length()-1;

        if(isNegative){
            split.insert(0, "-");
            left++;
            right++;
        }

        while(left < right){
            char temp = split.charAt(left);
            split.replace(left, left+1, String.valueOf(split.charAt(right)));
            split.replace(right, right+1, String.valueOf(temp));
            left++;
            right--;
        }

        try{
            return Integer.parseInt(split.toString());
        } catch (Exception e){
            return 0;
        }
    }


    public static int reverse(int x) {

        if(x >= -9 && x <= 9){
            return x;
        }

        boolean isNegative = x < 0;
        x = Math.abs(x);
        StringBuilder builder = new StringBuilder();
        if(isNegative){
            builder.append("-");
        }

        while(x / 10 != 0){
            builder.append(x%10);
            x = x / 10;

            if(1<= x && x <= 9){
                builder.append(x);
            }
        }

        try{
            Integer.parseInt(builder.toString());
        } catch (Exception e){
            return 0;
        } //-0042 = -42
        return Integer.parseInt(builder.toString());
    }
}
