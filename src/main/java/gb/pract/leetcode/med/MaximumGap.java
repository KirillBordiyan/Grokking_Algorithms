package gb.pract.leetcode.med;

import java.util.Arrays;

public class MaximumGap {
    public static void main(String[] args) {
        System.out.println(maximumGap(new int[]{1,1,1,1,1,5,5,5,5,5}));
        System.out.println(maximumGap(new int[]{0,0,0}));
        System.out.println(maximumGap(new int[]{1,3,100}));
        System.out.println(maximumGap(new int[]{3,6,9,1}));
    }

    public static int maximumGap(int[] nums) {
        if(nums.length <= 1){
            return 0;
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]) - Math.min(nums[0], nums[1]);
        }

        Arrays.sort(nums);
        int gap = 0;

        for(int i = 1; i < nums.length; i++){
            gap = Math.max(gap, nums[i] - nums[i-1]);

        }
        return gap;
    }
}
