package gb.pract.timus.cryptography;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Cryptography {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int index = Integer.parseInt(br.readLine());
            result.add(takeThePrimeOf(index));
        }

        br.close();

        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public static int takeThePrimeOf(int index) {
        if (index == 1) {
            return 2;
        }

        int count = 1;
        int number = 1;

        while (count < index) {
            number += 2;
            if (isPrime(number)) {
                count++;
            }
        }
        return number;
    }

    private static boolean isPrime(int number) {
        if (number <= 1)  return false;
        if (number <= 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;


        int sq = (int) Math.sqrt(number);
        for (int i = 5; i <= sq; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
