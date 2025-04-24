package gb.pract.leetcode.med;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class LetterCombination {
    public static void main(String[] args) {
        System.out.println(letterCombinations("0"));
        System.out.println(letterCombinations("234"));
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        Map<Integer, String[]> map = new HashMap<>();

        map.put(2, new String[]{"a", "b", "c"});
        map.put(3, new String[]{"d", "e", "f"});
        map.put(4, new String[]{"g", "h", "i"});
        map.put(5, new String[]{"j", "k", "l"});
        map.put(6, new String[]{"m", "n", "o"});
        map.put(7, new String[]{"p", "q", "r", "s"});
        map.put(8, new String[]{"t", "u", "v"});
        map.put(9, new String[]{"w", "x", "y", "z"});
        map.put(0, new String[]{""});

        if (digits.length() == 1) {
            return Arrays.stream(map.get(Integer.parseInt(digits))).toList();
        }

        List<Integer> split = new ArrayList<>(4);

        split.addAll(Arrays.stream(digits.split("")).map(Integer::parseInt).toList());
        while(split.size() != 4){
            split.add(0);
        }

        List<String> builder = new ArrayList<>();
//        Integer d1 = Integer.parseInt(split.get(0)); //2
//        Integer d2 = Integer.parseInt(split.get(1)); //3
//        Integer d3 = Integer.parseInt(split.get(2)); //4
//        Integer d4 = Integer.parseInt(split.get(3)); //0

        Integer d1 = split.get(0); //2
        Integer d2 = split.get(1); //3
        Integer d3 = split.get(2); //4
        Integer d4 = split.get(3); //0


        for (int j = 0; j < map.get(d1).length; j++) {
            for (int k = 0; k < map.get(d2).length; k++) {
                for (int m = 0; m < map.get(d3).length; m++) {
                    for (int n = 0; n < map.get(d4).length; n++)
                        builder.add(String.join("",
                                map.get(d1)[j],
                                map.get(d2)[k],
                                map.get(d3)[m],
                                map.get(d4)[n]));
                }
            }
        }


        return builder;

    }
}
