package gb.pract;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BinarySearch {
    /**
     * Бинарный поиск
     * Если элемент найден - его позиция
     * Если не найден - null
     * <p>
     * Выполняется за log2(n) - сколько раз надо умножить 2, чтобы получить n (log2(8) == 3, тк 2^3 = 8)
     */

    public static void main(String[] args) {
        List<Integer> defList = setInput(101);
        Integer searchNum = ThreadLocalRandom.current().nextInt(100);
        int resultPos = binarySearch(defList, searchNum);


        System.out.println(searchNum);
        System.out.println(resultPos);

    }

    public static int binarySearch(List<Integer> inputList, Integer toFind) {
        int left = 0;
        int right = inputList.size() - 1;
        var position = -1;

        while (left <= right) {
            int mid = left + right;
            Integer find = inputList.get(mid);
            if(find == toFind){
                position = mid;
            }
            if(find < toFind){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return position;
    }


    public static List<Integer> setInput(int len) {
        int current = 1;
        List<Integer> result = new ArrayList<>();
        while (current < len) {
            result.add(current++);
        }
        return result;
    }
}
