package gb.pract.timus;

import java.util.Scanner;

public class Democracy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        int[] people = new int[k];

        String[] start = sc.nextLine().split(" ");

        for(int i = 0; i < k; i++){
            people[i] = Integer.parseInt(start[i]);
        }

        quick(people, 0, people.length-1);
        //575
        //557

        int[] minPeople = new int[k];
        int minPart = 0;
        int minCountPeople = 0;

        for(int i = 0; i< k; i++){ //всего человек 5
            minPeople[i] = (people[i]/2) + 1; // челове за - минимум 3
            minPart += 1; //увеличиваем Н партий за
            minCountPeople += minPeople[i]; // считаем людей минимально нужных
            if(minPart > k/2){ //если больше половины партий за, то уже принято
                System.out.print(minCountPeople);
                return;
            }
        }



    }

    public static void quick(int[] nums, int left, int right) {

        if (nums.length == 0 || left >= right) return;

        int pivot = nums[(left + right) / 2]; //????????????????????????????????? почему так работает, а по-другому нет

        int i = left, j = right;
        while (i <= j) {
            while (nums[i] < pivot) i++;
            while (nums[j] > pivot) j--;
            if (i <= j) {
                if (i < j) {
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
