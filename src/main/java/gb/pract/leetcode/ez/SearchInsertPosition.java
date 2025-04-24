package gb.pract.leetcode.ez;

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1}, 1)); // 1
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2)); // 1
        System.out.println(searchInsert(new int[]{-6, -5, -3, -1}, -2)); // 3
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0)); // 0
        System.out.println(searchInsert(new int[]{-3, -1, 5, 6}, 0)); // 2
        System.out.println(searchInsert(new int[]{100}, 2)); // 0
        System.out.println(searchInsert(new int[]{100}, 200)); // 1
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, -1)); // 0
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5)); // 2
        System.out.println(searchInsert(new int[]{1, 2, 4, 5}, 3)); // 2
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 8)); // 4
    }

    public static int searchInsert(int[] nums, int target) {
        int position = 0;
        int left = 0, right = nums.length - 1;

        if(right == 0){
            if(nums[0] >= target){
                return 0;
            } else{
                return 1;
            }
        }

        while (left < right) {
            int middle = left + right;
            int searchingEl = nums[middle];
            if (searchingEl == target) {
                position = middle;
                break;
            }
            if (searchingEl > target) {
                if(nums[left] < target){
                    position = right;
                }
                right = middle - 1;
            } else {
                left = middle + 1;
                position = left;
            }
        }

        return position;

    }
}
