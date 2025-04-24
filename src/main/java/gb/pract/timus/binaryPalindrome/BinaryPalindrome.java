package gb.pract.timus.binaryPalindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String n = reader.readLine();

        int decimal = getDecimal(n);
        StringBuilder resultBinary = new StringBuilder();

        for (int i = 1; i <= decimal; i++) {
            getBinary(i, resultBinary);
        }
        System.out.println(getLenOfPalindrome(resultBinary.toString()));
    }

    public static int getLenOfPalindrome(String binary) {
        if (binary == null || binary.isEmpty()) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < binary.length(); i++) {
            int len1 = expand(binary, i, i);
            int len2 = expand(binary, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > max) {
                max = len;
            }
        }

        return max;
    }

    public static int expand(String binary, int left, int right) {
        while (left >= 0 && right < binary.length() && binary.charAt(left) == binary.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static int getDecimal(String binary) {
        int result = 0;
        for (int i = 0; i < binary.length(); i++) {
            result = result * 2 + (binary.charAt(i) - '0');
        }
        return result;

    }

    public static void getBinary(int decimal, StringBuilder result) {
        StringBuilder temp = new StringBuilder();
        while (decimal >= 1) {
            temp.append(decimal % 2);
            decimal = decimal / 2;
        }
        result.append(temp.reverse());

    }
}
