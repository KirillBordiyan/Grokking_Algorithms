package gb.pract.leetcode.med;

public class ZigZag {
    public static void main(String[] args) {

        System.out.println(convert("AB", 1));
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    public static String convert(String s, int numRows) {

        if(s.length() <= 1){
            return s;
        }

        StringBuilder[] builders = new StringBuilder[Math.max(numRows, s.length())];
        for(int b = 0; b < builders.length; b++){
            builders[b] = new StringBuilder();
        }



        boolean isGoUp = true;
        int currentRow = 0;

        for(int i = 0; i < s.length(); i++){
            StringBuilder builder = builders[currentRow];
            builder.append(s.charAt(i));

            if(currentRow == 0 || currentRow == numRows-1){
                isGoUp = !isGoUp;
            }

            if(isGoUp){
                currentRow--;
            } else {
                currentRow++;
            }
        }

        StringBuilder result = new StringBuilder();
        for(int j = 0; j < builders.length; j++){
            result.append(builders[j]);
        }

        return result.toString();

    }
}
