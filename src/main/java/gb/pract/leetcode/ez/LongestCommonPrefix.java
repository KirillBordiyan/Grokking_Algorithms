package gb.pract.leetcode.ez;

public class LongestCommonPrefix {
    public static void main(String[] args){
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs1));

        String[] strs2 = {"dog", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs2));

        String[] strs3 = {"fllwo", "flow", "flw"};
        System.out.println(longestCommonPrefix(strs3));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for(int i = 0; i < strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix= prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }
}
