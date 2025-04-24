package gb.pract.timus.mobileNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mobile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Character> map = getCharacterCharacterMap();

        Map<String, String> originalDict = new HashMap<>();
        Map<String, String> copyDict = new HashMap<>();
        Map<String, String> possibleFirstWord = new HashMap<>();

        String phoneNumber = sc.nextLine();
        StringBuilder result = new StringBuilder();


        outer:
        while (!phoneNumber.equals("-1")) {
            int n = Integer.parseInt(sc.nextLine());


            for (int i = 0; i < n; i++) {

                String word = sc.nextLine();
                StringBuilder charBuffer = new StringBuilder();

                for (Character ch : word.toCharArray()) {
                    charBuffer.append(map.get(ch));
                }
                originalDict.put(charBuffer.toString(), word);

                if (phoneNumber.startsWith(charBuffer.toString())) {
                    possibleFirstWord.put(charBuffer.toString(), word);
                }
            }


            boolean found = false;
            for (Map.Entry<String, String> entry : possibleFirstWord.entrySet()) {
                copyDict.putAll(originalDict);
                result = result.append(entry.getValue()).append(" ");
                int resLen = entry.getKey().length();
                String copyPhone = new String(phoneNumber.substring(resLen, phoneNumber.length()));

                for (int i = 1; i <= copyPhone.length(); i++) {
                    String pref = copyPhone.substring(0, i);
                    String s = copyDict.get(pref);

                    if (s != null) {
                        result.append(s).append(" ");
                        copyDict.remove(pref);
                        copyPhone = copyPhone.substring(i, copyPhone.length());
                        resLen += s.length();
                        if (resLen == phoneNumber.length()) {
                            System.out.println(result);
                            found = true;
                            break outer;
                        }
                        i = 0;
                    }
                }
            }
            if (!found) {
                System.out.println("No solution.");
            }
            result = new StringBuilder();
            phoneNumber = sc.nextLine();
        }

    }

    /*
7325189087
5
it
your
reality
real
our
-1
     */

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
