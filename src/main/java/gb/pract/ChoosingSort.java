package gb.pract;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ChoosingSort {
    public static void main(String[] args) {

        List<Integer> defaultList = setInput(20);
        System.out.println(defaultList);

        List<Integer> sorting = sorting(defaultList);
        System.out.println(sorting);
    }

    public static  List<Integer> sorting(List<Integer> input) {
        List<Integer> resultList = new ArrayList<>();

        for(int i = input.size(); i > 0; i--){
            int smallestIndex = findSmallerIndex(input);
            resultList.add(input.remove(smallestIndex));
        }
        return resultList;
    }

    public static int findSmallerIndex(List<Integer> input) {
        Integer smallest = input.get(0);
        int smallerIndex = 0;
        for (int i = 1; i < input.size() - 1; i++) {
            if (input.get(i) < smallest) {
                smallest = input.get(i);
                smallerIndex = i;
            }
        }
        return smallerIndex;
    }

    public static List<Integer> setInput(int len) {
        int current = 1;
        List<Integer> result = new ArrayList<>();
        while (current <= len) {
            result.add(ThreadLocalRandom.current().nextInt(1, 100));
            current++;
        }
        return result;
    }
}
