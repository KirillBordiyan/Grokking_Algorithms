package gb.pract.leetcode.med;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringToInt {
    public static void main(String[] args) {

        System.out.println(myAtoi("w")); //0
        System.out.println(myAtoi("213213123123123")); //0
        System.out.println(myAtoi(" - -w2")); //0
        System.out.println(myAtoi("   2w")); //2
        System.out.println(myAtoi("-2w2")); //-2

        System.out.println(myAtoi("   -w2")); //0
        System.out.println(myAtoi("-042")); //-42
        System.out.println(myAtoi("-")); //0
        System.out.println(myAtoi("+")); //0
        System.out.println(myAtoi("2")); // 2
        System.out.println(myAtoi("-2")); // -2
    }

    public static int myAtoi(String s) {

        StringBuilder result = new StringBuilder();
        boolean digitWas = false;
        boolean plusMinusWas = false;

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '-' || s.charAt(i) == '+' || s.charAt(i) == ' ') && (plusMinusWas || digitWas)) {
                break;
            } else if(s.charAt(i) == ' ' && (!plusMinusWas || !digitWas)){
                continue;
            }


            if (String.valueOf(s.charAt(i)).matches("\\d")) {
                digitWas = true;
                result.append(s.charAt(i));
                continue;
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+'){
                plusMinusWas = true;
                result.append(s.charAt(i));
                continue;
            }

            if (String.valueOf(s.charAt(i)).matches("\\D")) {
                break;
            }
        }

            return safe(result.toString());
    }

    public static int safe(String str){
        if ("+".equals(str) || "-".equals(str) || "".equals(str)) {
            return 0;
        }

        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return str.startsWith("-") ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
}
