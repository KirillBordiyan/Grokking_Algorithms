package gb.pract.leetcode.ez;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(45));
        System.out.println(climbStairs(46));
    }

    public static int climbStairs(int n) {

        int a1 = 1;
        int a2 = 2;
        int a3 = 0;

        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        for (int i = 0; i < n - 2; i++) {
            a3 = a2 + a1;
            a1 = a2;
            a2 = a3;
        }
        return a3;


        /*
        1 + 1 + 1 + 1 + 1 | 1
        1 + 1 + 1 + 2 | 4
        1 + 2 + 2 | 3

        5/5 = 1
        4/5 = 1.25
        3/5 = 0.6
         */
    }
}
