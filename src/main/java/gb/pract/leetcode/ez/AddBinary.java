package gb.pract.leetcode.ez;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1")); // 100
        System.out.println(addBinary("1111", "111")); // 10110
        System.out.println(addBinary("1100", "101")); // 10001
        System.out.println();

        System.out.println(addBinary2("11", "1")); // 100
        System.out.println(addBinary2("1111", "111")); // 10110
        System.out.println(addBinary2("1100", "101")); // 10001

    }

    public static String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }

        StringBuilder ans = new StringBuilder();
        int c = 0;
        int aLen = a.length();
        int bLen = b.length();

        for (int i = 1; i <= aLen; i++) {
            int j;
            if (i <= bLen) {
                j = (a.charAt(aLen - i) - '0') + (b.charAt(bLen - i) - '0') + c;
                c = 0;
            } else {
                j = (a.charAt(aLen - i) - '0') + c;
                c = 0;
            }

            if (j == 1) {
                ans.append('1');
            } else if (j == 2) {
                ans.append('0');
                c = 1;
            } else if (j == 3) {
                ans.append('1');
                c = 1;
            } else {
                ans.append('0');
            }
        }

        if (c == 1) {
            ans.append('1');
        }

        return ans.reverse().toString();
    }

    public static String addBinary2(String a, String b) {
        String[] splitA = a.split("");
        String[] splitB = b.split("");


        String[] max;
        String[] min;

        if (a.length() >= b.length()) {
            max = splitA;
            min = splitB;
        } else {
            max = splitB;
            min = splitA;
        }

        StringBuilder build = new StringBuilder();


        int ov = 0;
        for (int i = 1; i <= max.length; i++) {
            int j;
            if (min.length - i >= 0) {
                j = Integer.parseInt(max[max.length - i]) + Integer.parseInt(min[min.length - i]) + ov;
                ov = 0;
            } else {
                j = Integer.parseInt(max[max.length - i]) + ov;
                ov = 0;
            }

            if (j == 3) {
                build.append("1");
                ov = 1;
            } else if (j == 2) {
                build.append("0");
                ov = 1;
            } else if (j == 1) {
                build.append("1");
            } else if (j == 0) {
                build.append("0");
            }
        }

        if (ov == 1) {
            build.append("1");
        }


        return build.reverse().toString();


    }
}
