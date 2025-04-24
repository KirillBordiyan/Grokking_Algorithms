package gb.pract.leetcode.med;

import java.util.Arrays;

public class MaxConsecutiveFloors {
    public static void main(String[] args) {
        System.out.println(maxConsecutive(28, 50, new int[]{35, 48}));
        System.out.println(maxConsecutive(10, 30, new int[]{19, 10, 15}));
        System.out.println(maxConsecutive(2, 9, new int[]{4, 6}));
        System.out.println(maxConsecutive(6, 8, new int[]{7, 6, 8}));
    }

    public static int maxConsecutive(int bottom, int top, int[] special) {
        // [bot, f2, f3, f4, s1,f5, s2,top]

        if (top - bottom <= special.length) {
            return 0;
        }
        Arrays.sort(special);

        int max= Math.max(special[0] - bottom, top - special[special.length-1]);

        for(int i = 1; i < special.length; i++){
            max = Math.max(max, special[i]-special[i-1]-1 );
        }
        return max;
    }
}
