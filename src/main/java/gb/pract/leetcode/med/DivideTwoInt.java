package gb.pract.leetcode.med;

public class DivideTwoInt {
    public static void main(String[] args) {
        System.out.println(div(-10, -3));
        System.out.println(div(-10, 3));
        System.out.println(div(-2147483648, -1)); // ..47
        System.out.println(div(-2147483648, 1)); // -48
        System.out.println(div(2147483647, 1)); // 47
        System.out.println(div(-2147483647, 1)); //
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public static int div(int dividend, int divisor) {

        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        return dividend/divisor;
    }

    public static int divide(int dividend, int divisor) {
        boolean dividendN = dividend < 0;
        boolean divisorN = divisor < 0;
        int dividendABS = Math.abs(dividend);
        int divisorABS = Math.abs(divisor);
        int count = 0;

        while(dividendABS - divisorABS >= 0){
            dividendABS -=divisorABS;
            count++;
        }
        if(dividendN && divisorN){
            return count < Integer.MAX_VALUE ? count : Integer.MAX_VALUE;
        }
        if(dividendN || divisorN){
            return -count < Integer.MIN_VALUE ? Integer.MIN_VALUE: -count;
        }
        return count;
    }
}
