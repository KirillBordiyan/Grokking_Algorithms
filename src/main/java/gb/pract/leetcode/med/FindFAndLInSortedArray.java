package gb.pract.leetcode.med;

import java.util.Arrays;

public class FindFAndLInSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{1, 1, 1, 1, 1}, 1))); //0 4
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2}, 2))); // 1 1
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8))); // 3 4
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6))); // -1 -1
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0))); // -1 -1
        System.out.println(Arrays.toString(searchRange(new int[]{1, 1}, 0))); // -1 -1
        System.out.println(Arrays.toString(searchRange(new int[]{1, 1, 1, 1, 1}, 2))); //-1 -1
        System.out.println();
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        }
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[]{-1, -1};

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                for (int i = mid; i >= 0; i--) {
                    if(i == 0 && nums[i] == target){
                        result[0] = i;
                        break;
                    }
                    if (nums[i - 1] < target) {
                        result[0] = i;
                        break;
                    }
                    if (nums[i] == target) {
                        result[0] = i;
                    }
                }
                for (int i = mid; i < nums.length; i++) {
                    if(i == nums.length-1 && nums[i] == target){
                        result[1] = i;
                        break;
                    }
                    if (nums[i + 1] > target) {
                        result[1] = i;
                        break;
                    }
                    if (nums[i] == target) {
                        result[1] = i;
                    }
                }
                return result;
            } else {
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return result;
    }
}
