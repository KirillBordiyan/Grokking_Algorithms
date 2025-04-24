package gb.pract.leetcode.med;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        nextPermutation(new int[]{2, 1});
        nextPermutation(new int[]{2, 3});
        nextPermutation(new int[]{2});
        nextPermutation(new int[]{2,3,1});
        nextPermutation(new int[]{1,3,2}); // che za huinya 2 1 3
        nextPermutation(new int[]{1,1,5});
        nextPermutation(new int[]{1,2,3});
        nextPermutation(new int[]{1, 3, 5, 4, 2});
        nextPermutation(new int[]{1, 5, 4, 3, 2}); //  2 1 3 4 5
        nextPermutation(new int[]{3, 5, 4, 2, 1}); // 4, 1, 2, 3, 5
    }



    public static void nextPermutation(int[] nums) {
        // 1 3cl [5rj 4 2]
        int current = nums[nums.length - 1];
        int maxR = 101;
        int rightJ = 0;
        outer:
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= current) {
                current = nums[i];
            } else {
                int currentLeft = nums[i];
                for (int j = nums.length - 1; j > i; j--) {
                    if (currentLeft < nums[j]) {
                        if (nums[j] - currentLeft < maxR) {
                            maxR = nums[j] - currentLeft;
                            rightJ = j;
                        }
                        if (j - 1 == i) {
                            int temp = nums[i];
                            nums[i] = nums[rightJ];
                            nums[rightJ] = temp;
                            Arrays.sort(nums, i+1, nums.length);
                            break outer;
                        }
                    }
                }
            }
        }
        if(maxR == 101){
            Arrays.sort(nums);
            System.out.println(Arrays.toString(nums));
        } else{
            System.out.println(Arrays.toString(nums));
        }
    }
}
