package gb.pract.leetcode.ez;

public class FindFirstOccurrence {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("iwhertuher", "her"));
        System.out.println(strStr("f", ""));
        System.out.println(strStr("f", "f"));
        System.out.println(strStr("fa", "f"));
    }

    public static int strStr(String haystack, String needle) {

        if(haystack.length() == 1 || haystack.lastIndexOf(needle) == 0){
            if(haystack.contains(needle)){
                return 0;
            }
        }
        if(haystack.lastIndexOf(needle) != 0){
            return haystack.indexOf(needle);
        }

        return -1;
    }
}
