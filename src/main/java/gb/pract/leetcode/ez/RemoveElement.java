package gb.pract.leetcode.ez;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3,2,2,3}, 3));
        System.out.println(removeElement(new int[]{2,1,2,2,3,0,4,2}, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int k = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[k+1] = nums[i];
                k++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return k+1;
    }
}
