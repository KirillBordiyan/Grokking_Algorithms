package gb.pract.leetcode.med;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1000, -5, -5,-5, -1, -1}, -14)); // -15
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1)); // 2
        System.out.println(threeSumClosest(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2)); // -2
        System.out.println(threeSumClosest(new int[]{-1, 0, 1, 2, -1, -4}, 4)); // 3
        System.out.println(threeSumClosest(new int[]{1, 1, 1, 0}, -100)); // 0 1 1 1 - 2
        System.out.println(threeSumClosest(new int[]{0, 0, 0}, 0)); // -> 0
        System.out.println(threeSumClosest(new int[]{-1, 2, 0, -1, -4}, 1)); // 1
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        if(nums[0] + nums[1] + nums[2] > target){
            return nums[0] + nums[1] + nums[2];
        }
        if (nums[nums.length-3] + nums[nums.length-2] + nums[nums.length-1] < target) {
            return nums[nums.length-3] + nums[nums.length-2] + nums[nums.length-1];
        }

        int result = 0;
        int min = nums[0] + nums[1] + nums[nums.length - 1];

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int y = i + 1;
            int z = nums.length - 1;

            int sum;

            while (y < z) {

                sum = nums[i] + nums[y] + nums[z];
                if (Math.abs(target-min) > Math.abs(target - sum)) {
                    min = sum;
                }

                if (sum == target) {
                    result = sum;
                    break;
                } else if (sum > target) {
                    while (y < z && nums[z] == nums[z - 1]) {
                        z--;
                    }
                    result=min;
                    z--;

                } else if (sum < target) {
                    while (y < z && nums[y] == nums[y + 1]) {
                        y++;
                    }
                    result=min;
                    y++;
                }
            }

        }
        return result;
    }
}
