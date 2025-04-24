package gb.pract.leetcode.ez;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] s){
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        String[] split = s.split("");
        int result = map.get(split[split.length-1]);

        for(int i = split.length-2; i>=0; i--){
            if(map.get(split[i]) < map.get(split[i+1])){
                result -= map.get(split[i]);
            } else {
                result += map.get(split[i]);
            }
        }

        return  result;
    }



}
