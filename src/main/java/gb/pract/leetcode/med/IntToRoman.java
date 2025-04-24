package gb.pract.leetcode.med;


public class IntToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(3749));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {

        StringBuilder build = new StringBuilder();

        final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] symbols = {"M", "CM", "D",  "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


        for(int i = 0; i < values.length; i++){
            if(num <= 0 ){
                break;
            }
            while(num>= values[i]){
                build.append(symbols[i]);
                num -= values[i];
            }
        }
        return build.toString();
    }
}
