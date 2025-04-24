package gb.pract.timus.cryptography;

import java.util.Scanner;

public class CryptographyAI {


    /**
     * Решение задачи по вычислению n-го простого числа.
     * Алгоритм основан на последовательной проверке чисел на простоту,
     * начиная с 2 (первое простое число), и подсчете количества найденных простых чисел.
     * Для оптимизации используется проверка только нечетных чисел (кроме 2)
     * и проверка делимости только на числа вида 6k±1 до корня из проверяемого числа.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение количества запросов
        int k = Integer.parseInt(scanner.nextLine());

        // Чтение запросов построчно

        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            System.out.println(findNthPrime(n));
        }

        scanner.close();
    }

    /**
     * Находит n-ое простое число
     */
    private static int findNthPrime(int n) {
        if (n == 1) return 2;

        int count = 1; // Уже учли 2 как первое простое число
        int num = 1;

        while (count < n) {
            num += 2; // Проверяем только нечетные числа, так как четные (кроме 2) не являются простыми
            if (isPrime(num)) {
                count++;
            }
        }

        return num;
    }

    /**
     * Проверяет, является ли число простым
     */
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;

        // Проверяем делители вида 6k±1 до корня из num
        int sqrtNum = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrtNum; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }

        return true;



    }
}
