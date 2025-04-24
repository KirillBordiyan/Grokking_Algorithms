package gb.pract.leetcode.ez;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        two(new int[]{2, 7,11, 15}, 9);
    }


    public static int[] two(int[] nums, int target) {
        // Create a map to store the number and its corresponding index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // If found, return the indices
                return new int[]{map.get(complement), i};
            }

            // If not found, add the current number and its index to the map
            map.put(nums[i], i);
        }

        // If no solution is found (though the problem guarantees there is one), return an empty array
        return new int[]{};
    }

}
