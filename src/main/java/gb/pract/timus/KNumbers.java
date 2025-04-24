package gb.pract.timus;

import java.math.BigInteger;
import java.util.Scanner;

public class KNumbers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int K = Integer.parseInt(sc.nextLine());

        BigInteger k1 = BigInteger.valueOf(K - 1);
        BigInteger A = k1;
        BigInteger B = BigInteger.ZERO;

        for (int i = 2; i <= N; i++) {
            BigInteger newA = A.add(B).multiply((k1));
            BigInteger newB = A;

            A = newA;
            B = newB;
        }

        System.out.println(A.add(B));
    }
}
