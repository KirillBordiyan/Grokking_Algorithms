package gb.pract.leetcode.ez;

public class LengthLastWord {
    public static void main(String[] args){
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("Hello boy"));
        System.out.println(lengthOfLastWord(" "));
    }

    public static int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        if(split.length == 0){
            return 0;
        }
        String lastWord = split[split.length-1];

        String[] splitLast = lastWord.split("");
        return splitLast.length;
    }
}
