package gb.pract;

public class DivideEtImpera {
    /**
     * Для решения по стратегии "разделяй и властвуй" нужно 2 условия:
     * 1) базовый случай, он же простейший
     * 2) свести задачу к базовому случаю
     * @param args
     */
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 4, 6, 7, 3, 2};

        System.out.println(sum(numbers, 0));
        System.out.println(countOf(numbers, 0));
        System.out.println(max(numbers, 0));

    }

    public static int max(int[] arr, int index){ //?????

        if(arr.length - 1 == index){
            return arr[index];
        } else {
            int max = max(arr, index + 1);
            return Math.max(arr[index], max);
        }

    }


    public static int countOf(int[] arr, int start){//???

        int count = start;
        if(count != arr.length){
            return countOf(arr, ++count);
        } else {
            return count;
        }
    }

    public static int sum(int[] arr, int start){
        int current = start;

        if(arr.length == current){
            return 0;
        } else {
            return arr[current++] + sum(arr, current);
        }
    }
}
