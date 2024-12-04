package gb.pract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSortPart2 {
    public static void main(String[] args) {

        int[] numbers = new int[] {12,3,43,543,645,7,567,768,234,324,546,412,4124};

        quick(numbers, 0, numbers.length-1);

        System.out.println(Arrays.toString(numbers));

    }

    public static void quick(int[] nums, int left, int right) {

        if(nums.length == 0 || left >= right) return;

        int pivot = nums[(left+right)/2]; //????????????????????????????????? почему так работает, а по-другому нет

        int i = left, j = right;
        while(i <= j){
            while (nums[i] < pivot) i++;
            while(nums[j] > pivot) j--;
            if(i <= j){
                if(i < j){
                    int swap = nums[i];
                    nums[i] = nums[j];
                    nums[j] = swap;
                }
                i++;
                j--;
            }
        }

        if(left < j) quick(nums, left, j);
        if(right > i) quick(nums, i, right);
    }






}
