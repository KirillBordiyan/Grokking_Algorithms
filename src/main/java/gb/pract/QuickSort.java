package gb.pract;

import java.io.BufferedWriter;
import java.util.Arrays;

public class QuickSort {
    /**
     * Для быстрой сортировки есть последовательность действий:
     * 1) выбор опорного элемента (пусть N)
     * 2) разделение массива на 2 - один с элементами больше N, другой меньше N
     * 3) для таких подмассивов рекурсивно вызывать быструю сортировку
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] numbers = new int[]{1, 4, 62, 7, 3, 2, 4, 5, 6, 7, 8, 23, 64, 34, 98, 22};
        System.out.println(Arrays.toString(numbers));
        quickSort(numbers, 0, numbers.length - 1);

    }

    public static void quickSort(int[] numbers, int left, int right) {
        if (left < right) {
            int goalIndexAfterPartition = part(numbers, left, right);
//            print(numbers, left, right, goalIndexAfterPartition);
            print(numbers,  goalIndexAfterPartition);
            quickSort(numbers, left, goalIndexAfterPartition - 1);
            quickSort(numbers, goalIndexAfterPartition, right);
        }

    }

    public static int part(int[] numbers, int left, int right) {
        int leftI = left;
        int rightI = right;

        int pivot = numbers[leftI];
        while(leftI <= rightI){
            while(numbers[leftI] < pivot){
                leftI++;
            }

            while(numbers[rightI] > pivot){
                rightI--;
            }

            if(leftI <= rightI){
                swap(numbers, leftI, rightI);
                leftI++;
                rightI--;
            }
        }
        return leftI;
    }

    public static void swap(int[] numbers, int left, int right){
        int tmp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = tmp;
    }

    public static void print(int[] numbers, int partIndex){
        System.out.println("левая");
        for(int i = 0; i < partIndex; i++){
            System.out.printf("%s ", numbers[i]);
        }
        System.out.println();
        System.out.println("правая");
        for (int i = partIndex; i < numbers.length; i++){
            System.out.printf("%s ", numbers[i]);
        }
        System.out.println();

    }

//    private static String arrayToString(int[] array) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("[");
//        for (int i = 0; i < array.length; i++) {
//            if (i > 0) {
//                sb.append(", ");
//            }
//            sb.append(array[i]);
//        }
//        sb.append("]");
//        return sb.toString();
//    }
//
//    private static void print(int[] arr, int from, int to, int partitionIndex) {
//        System.out.print(arrayToString(arr));
//        System.out.print("\npartition at index: " + partitionIndex);
//        System.out.print(", left: " + arrayToString(Arrays.copyOfRange(arr, from, partitionIndex)));
//        System.out.println(", right: " + arrayToString(Arrays.copyOfRange(arr, partitionIndex, to + 1)) + "\n");
//    }

}
