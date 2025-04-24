package gb.pract.timus.cryptography;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CryptographyEratosphen {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(reader.readLine());
        List<Integer> input = new ArrayList<>();

        int max = 0;
        for (int i = 0; i < k; i++) {
            int index = Integer.parseInt(reader.readLine());
            input.add(index);
            max = Math.max(max, index);
        }
        reader.close();


        List<Integer> primes = findPrimes(max);

        for (int i : input) {
            System.out.println(primes.get(i - 1));
        }
    }

    public static List<Integer> findPrimes(int bound) {
        int upper;
        if (bound < 5) {
            upper = 12;
        } else {
            upper = (int) (bound * (Math.log(bound) + Math.log(Math.log(bound))));
            upper = Math.max(upper, bound * 2);

        }

        boolean[] isPrimes = new boolean[upper + 1];

        for (int i = 2; i <= upper; i++) {
            isPrimes[i] = true;
        }

        for(int i = 2; i * i <= upper; i++){
            if(isPrimes[i]){
                for(int j = i * i; j <= upper; j += i){
                    isPrimes[j] = false;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 2; i <= upper && res.size() < bound; i++){
            if(isPrimes[i]){
                res.add(i);
            }
        }
        return res;
    }
}
