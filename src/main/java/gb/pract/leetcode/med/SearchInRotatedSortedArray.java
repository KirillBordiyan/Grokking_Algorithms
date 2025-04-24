package gb.pract.leetcode.med;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6}, 4)); // 3
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); // 4
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)); // -1
        System.out.println(search(new int[]{1}, 0)); // -1
        System.out.println(search(new int[]{1, 3}, 0)); // -1

    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (right == 0) {
            return nums[right] == target ? right : -1;
        }

        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) { //сохраняет последовательность по возрастанию
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // произошло убывание
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
