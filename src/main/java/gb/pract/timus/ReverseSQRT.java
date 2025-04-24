package gb.pract.timus;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class ReverseSQRT {



    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Long> numbers = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line);

            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                try {
                    long number = Long.parseLong(token);
                    numbers.add(number);
                } catch (NumberFormatException e) {
                }
            }
        }

        reader.close();

        for (int i = numbers.size() - 1; i >= 0; i--) {
            double sqrt = Math.sqrt(numbers.get(i));
            System.out.printf("%.4f%n", sqrt);
        }
    }
}



