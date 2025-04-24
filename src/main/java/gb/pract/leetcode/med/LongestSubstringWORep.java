package gb.pract.leetcode.med;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LongestSubstringWORep {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf")); // 3
        System.out.println(lengthOfLongestSubstring("qrsvbspk")); // 5
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("ay")); // 2
        System.out.println(lengthOfLongestSubstring("ayy")); // 2
        System.out.println(lengthOfLongestSubstring("a")); // 1
        System.out.println(lengthOfLongestSubstring("dddd")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }

        Map<Character, Integer> map = new HashMap<>();
        int maxSize = 0;

        for(int i = 0, j = i; j < s.length(); j++){
            if(map.get(s.charAt(j)) == null){
                map.put(s.charAt(j), j);
                if(maxSize < map.size()){
                    maxSize = map.size();
                }
            } else if(map.get(s.charAt(j)) != null) {
                if(maxSize < map.size()){
                    maxSize = map.size();
                }
                i = map.get(s.charAt(j));
                map.clear();
                j=i;
            }
        }
        return maxSize;
    }
}
