package gb.pract.timus.mobileNumber;

import java.io.IOException;
import java.util.*;

public class MobileNumber {

    public static void main(String[] args) throws IOException {
        Map<Character, Character> map = getCharacterCharacterMap();

        Scanner reader = new Scanner(System.in);

        List<String> result;
        Map<String, String> dict;
        Map<String, String> copyDict;
        String numberS = reader.nextLine();


        while (!numberS.equals("-1")) {
            result = new ArrayList<>();
            int size = Integer.parseInt(reader.nextLine());
            dict = new HashMap<>();

            for (int i = 1; i <= size; i++) {
                String word = reader.nextLine();
                char[] input = word.toCharArray();
                StringBuilder buffer = new StringBuilder();
                for (char c : input) {
                    buffer.append(map.get(c));
                }
                if (numberS.contains(buffer.toString())) {
                    result.add(buffer.toString());
                    dict.put(buffer.toString(), word);
                }
            }

            List<String> out = new ArrayList<>();
            int j = 0;
            if (!result.isEmpty()) {
                while (!numberS.isEmpty() || j < result.size()) {
                    for (; j < result.size(); ) {
                        if (numberS.startsWith(result.get(j))) {
                            numberS = numberS.replaceFirst(result.get(j), "");
                            out.add(dict.get(result.get(j)));
                        }
                        j++;
                    }
                }
            }


            if (out.isEmpty()) {
                System.out.print("\n");
                System.out.print("No solution.");
            } else {
                System.out.print("\n");
                for (String str : out) {
                    System.out.print((str + " ").trim());
                }
            }

            numberS = reader.nextLine();
        }
    }

    private static Map<Character, Character> getCharacterCharacterMap() {
        Map<Character, Character> map = new HashMap<>();
        map.put('a', '2');
        map.put('b', '2');
        map.put('c', '2');
        map.put('d', '3');
        map.put('e', '3');
        map.put('f', '3');
        map.put('g', '4');
        map.put('h', '4');
        map.put('k', '5');
        map.put('l', '5');
        map.put('m', '6');
        map.put('n', '6');
        map.put('p', '7');
        map.put('r', '7');
        map.put('s', '7');
        map.put('t', '8');
        map.put('u', '8');
        map.put('v', '8');
        map.put('w', '9');
        map.put('x', '9');
        map.put('y', '9');
        map.put('o', '0');
        map.put('q', '0');
        map.put('z', '0');
        map.put('i', '1');
        map.put('j', '1');
        return map;
    }
}