package gb.pract.timus.mobileNumber;


import java.io.IOException;
import java.util.*;

public class MobileNumberAi {

    public static void main(String[] args) throws IOException {
        Map<Character, Character> map = getCharacterCharacterMap();
        Scanner scanner = new Scanner(System.in);

        String phoneNumber = scanner.nextLine();

        while (!phoneNumber.equals("-1")) {
            int dictSize = Integer.parseInt(scanner.nextLine());

            // Словари для хранения информации о словах
            List<String> originalWords = new ArrayList<>(dictSize);
            List<String> encodedWords = new ArrayList<>(dictSize);

            // Считываем словарь и кодируем слова
            for (int i = 0; i < dictSize; i++) {
                String word = scanner.nextLine();
                originalWords.add(word);

                StringBuilder encoded = new StringBuilder();
                for (char c : word.toCharArray()) {
                    encoded.append(map.get(c));
                }
                encodedWords.add(encoded.toString());
            }

            // Находим решение с минимальным числом слов
            List<Integer> solution = findMinCoverSolution(phoneNumber, encodedWords);

            // Выводим результат
            if (solution == null || solution.isEmpty()) {
                System.out.print("\n");
                System.out.print("No solution.");
            } else {
                System.out.print("\n");
                for (int index : solution) {
                    System.out.print((originalWords.get(index) + " ").trim());
                }
            }

            // Считываем следующий номер
            phoneNumber = scanner.nextLine();
        }

        scanner.close();
    }

    /**
     * Находит минимальное покрытие номера словами из словаря
     */
    private static List<Integer> findMinCoverSolution(String phoneNumber, List<String> encodedWords) {
        int n = phoneNumber.length();

        // dp[i] будет хранить минимальное количество слов для покрытия префикса длины i
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Для пустой строки нужно 0 слов

        // prev[i] хранит индекс слова, которое покрывает последнюю часть префикса длины i
        int[] prev = new int[n + 1];
        Arrays.fill(prev, -1);

        // Заполняем dp массив
        for (int i = 0; i < n; i++) {
            // Пропускаем позиции, которые не могут быть достигнуты
            if (dp[i] == Integer.MAX_VALUE) continue;

            // Проверяем каждое слово
            for (int j = 0; j < encodedWords.size(); j++) {
                String word = encodedWords.get(j);
                int wordLength = word.length();

                // Проверяем, можно ли применить текущее слово, начиная с позиции i
                if (i + wordLength <= n && phoneNumber.substring(i, i + wordLength).equals(word)) {
                    // Если новое решение лучше предыдущего
                    if (dp[i] + 1 < dp[i + wordLength]) {
                        dp[i + wordLength] = dp[i] + 1;
                        prev[i + wordLength] = j;
                    }
                }
            }
        }

        // Если dp[n] = MAX_VALUE, значит номер нельзя покрыть словами из словаря
        if (dp[n] == Integer.MAX_VALUE) {
            return null;
        }

        // Восстанавливаем решение
        List<Integer> solution = new ArrayList<>();
        int pos = n;
        while (pos > 0) {
            int wordIndex = prev[pos];
            solution.add(0, wordIndex); // Добавляем в начало списка
            pos -= encodedWords.get(wordIndex).length();
        }

        return solution;
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
