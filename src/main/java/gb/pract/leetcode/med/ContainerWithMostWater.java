package gb.pract.leetcode.med;

public class ContainerWithMostWater {
    public static void main(String[] args) {

        System.out.println(maxArea(new int[]{1,2})); //49
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7})); //49
        System.out.println(maxArea(new int[]{1,1})); //1
        System.out.println(maxArea(new int[]{0,1})); //0
        System.out.println(maxArea(new int[]{1,1,2,3})); //2
        System.out.println(maxArea(new int[]{1,1,2,4})); //3
        System.out.println(maxArea(new int[]{1,2,2,4})); //4

    }

    public static int maxArea(int[] height) {
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }

        int left = 0, right = height.length - 1;
        int maxSum = 0;

        while (left < right) {
            int currentSum = Math.min(height[left], height[right]) * (right-left);

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxSum;

    }
}
