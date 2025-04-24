package gb.pract.timus.binaryPalindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryPalindromeAI {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n = reader.readLine();
        int decimal = getDecimal(n);

        System.out.println(findLongestPalindromeLength(decimal));
    }

    // Оптимизированный метод поиска максимальной длины палиндрома
    public static int findLongestPalindromeLength(int decimal) {
        // Кольцевой буфер для хранения последних символов
        // Выбираем размер, достаточный для хранения ожидаемой длины палиндрома
        final int BUFFER_SIZE = 100000; // Настройте в зависимости от задачи
        char[] buffer = new char[BUFFER_SIZE];
        int bufferPos = 0;
        int bufferFilled = 0;

        int maxPalindromeLength = 0;

        // Обрабатываем каждое число от 1 до decimal
        for (int i = 1; i <= decimal; i++) {
            // Получаем бинарное представление числа
            StringBuilder binaryBuilder = new StringBuilder();
            int num = i;
            while (num > 0) {
                binaryBuilder.insert(0, num % 2); // Вставляем в начало для правильного порядка
                num /= 2;
            }
            String binary = binaryBuilder.toString();

            // Добавляем каждый бит в буфер и проверяем палиндромы
            for (int j = 0; j < binary.length(); j++) {
                char bit = binary.charAt(j);

                // Добавляем бит в буфер
                buffer[bufferPos] = bit;
                bufferPos = (bufferPos + 1) % BUFFER_SIZE;
                if (bufferFilled < BUFFER_SIZE) {
                    bufferFilled++;
                }

                // Проверяем палиндромы, только если накопилось достаточно символов
                if (bufferFilled > 1) {
                    // Палиндромы нечетной длины (центр в текущей позиции)
                    int palindromeLength = expandInBuffer(buffer, bufferPos - 1, bufferPos - 1, BUFFER_SIZE, bufferFilled);
                    maxPalindromeLength = Math.max(maxPalindromeLength, palindromeLength);

                    // Палиндромы четной длины (центр между текущей и предыдущей позициями)
                    if (bufferFilled > 2) {
                        palindromeLength = expandInBuffer(buffer, bufferPos - 2, bufferPos - 1, BUFFER_SIZE, bufferFilled);
                        maxPalindromeLength = Math.max(maxPalindromeLength, palindromeLength);
                    }
                }
            }
        }

        return maxPalindromeLength;
    }

    // Расширение палиндрома в буфере от центральной позиции
    private static int expandInBuffer(char[] buffer, int left, int right, int bufferSize, int bufferFilled) {
        int originalLeft = left;
        int originalRight = right;

        // Нормализуем индексы в пределах буфера
        left = (left + bufferSize) % bufferSize;
        right = (right + bufferSize) % bufferSize;

        // Расширяем палиндром в обе стороны
        while (true) {
            int newLeft = (left - 1 + bufferSize) % bufferSize;
            int newRight = (right + 1) % bufferSize;

            // Проверяем, не вышли ли мы за пределы заполненной части буфера
            int leftOffset = (originalLeft - newLeft + bufferSize) % bufferSize;
            int rightOffset = (newRight - originalRight + bufferSize) % bufferSize;

            if (leftOffset >= bufferFilled || rightOffset >= bufferFilled) {
                break;
            }

            if (buffer[newLeft] != buffer[newRight]) {
                break;
            }

            left = newLeft;
            right = newRight;
        }

        // Вычисляем длину найденного палиндрома
        int length;
        if (left <= right) {
            length = right - left + 1;
        } else {
            length = bufferSize - left + right + 1;
        }

        return length;
    }

    // Преобразование бинарной строки в десятичное число
    public static int getDecimal(String binary) {
        int result = 0;
        for (int i = 0; i < binary.length(); i++) {
            result = result * 2 + (binary.charAt(i) - '0');
        }
        return result;
    }
}
