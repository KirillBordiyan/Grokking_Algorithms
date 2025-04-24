package gb.pract.timus;

import java.util.Scanner;

public class RecolorOfLine {

    public static void main(String[] args) {
        Integer maxPoint = 1_000_000_000;
        Integer minPoint = 0;

        Integer maxLen = maxPoint - minPoint;

        int leftR = maxPoint;
        int rightR = minPoint;

        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < N; i++) {
            String[] split = sc.nextLine().split(" ");
            Integer left = Integer.parseInt(split[0]);
            Integer right = Integer.parseInt(split[1]);

            if (split[2].equals("b") && left - minPoint > maxPoint - right) {
                leftR = left;
                rightR = right;
                maxLen = right - left;
            } else {

            }
        }
    }
}
