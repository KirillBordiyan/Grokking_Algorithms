package gb.pract.leetcode.ez;

public class SqrtX {
    public static void main(String[] args) {
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(9));
        System.out.println(mySqrt(2147395599));
    }


    public static int mySqrt(int x) {

        if (x == 1 || x == 0) {
            return x;
        }

        long left = 0, right = x;
        while (right - left > 1) {

            long mid = (left + right) / 2;
            long target = mid * mid;

            if (target == x) {
                return (int) mid;
            } else if (target > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return (int) left;

        /*
            х=8
            8^1/2 - ?

            1 2 3 4 5 7 8

            1^2 >= 8?
            2^2 >= 8?
            3^2 > 8+


            2..3
         */
    }
}
