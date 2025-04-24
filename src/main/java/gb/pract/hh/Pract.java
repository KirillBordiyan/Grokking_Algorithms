package gb.pract.hh;

import java.util.ArrayList;
import java.util.List;

public class Pract {
    public static void main(String[] args) {
        System.out.println(filterStrings("Password1 Pass@word 12345 pass!word Passw@rd Password1!"));
        System.out.println(findSafePasswords("Password1 Pass@word 12345 pass!word Passw@rd Password1!"));

        System.out.println(find("0 5 2 7 4 1"));
        System.out.println(find("10 8 6 4 2 0 -2 -4"));

        System.out.println();
        System.out.println(checkPal("Прогр"));
        System.out.println(checkPal("шалаш"));
    }

    private static final String specialChars = "!@#$%^&*()-+";

    public static String findSafePasswords(String input) {
        String[] split = input.split(" ");
        StringBuilder build = new StringBuilder();

        for (String s : split) {
            if (s.length() < 8 &&
                    !s.matches("a-zA-Z")
                    && !s.matches(specialChars)
                    && !s.matches("1-9")) {
                continue;
            }
            build.append(s).append(" ");
        }
        if (build.isEmpty()) {
            return "Не найдено";
        }


        return build.toString();
    }


    public static String filterStrings(String input) {
        List<String> result = new ArrayList<>();
        String[] split = input.split(" ");

        for (String el : split) {
            if (isValid(el)) {
                result.add(el);
            }
        }
        if (result.isEmpty()) {
            return "Не найдено";
        }
        return String.join(" ", result);
    }

    private static boolean isValid(String str) {
        if (str.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (specialChars.indexOf(c) != -1) {
                hasSpecialChar = true;
            }
        }

        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }


    public static String find(String input) {
        String[] split = input.split(" ");

        StringBuilder build = new StringBuilder();

        for (int i = 1; i < split.length; i++) {
            int current = Integer.parseInt(split[i]);
            int prev = Integer.parseInt(split[i - 1]);
            if (prev - current >= 3) {
                build.append(i).append(" ");
            }
        }

        if (build.length() == 0) {
            return "Нет";
        }

        return build.toString().trim();

    }

    public static String checkPal(String input) {
        input = input.toLowerCase();

        int left = 0;
        int right = input.length() - 1;

        while (left <= right) {
            if (input.charAt(left) == input.charAt(right)) {
                left++;
                right--;
            } else {
                return "Не палиндром";
            }
        }
        return "Палиндром";
    }

    public static String calculate(String s) {
        String[] split = s.split(" ");

        int countZero = 0;
        int countUpper = 0;
        int countLower = 0;

        for (int i = 0; i < split.length; i++) {
            if (Integer.parseInt(split[i]) == 0) {
                countZero++;
            } else if (Integer.parseInt(split[i]) > 0) {
                countUpper++;
            } else if (Integer.parseInt(split[i]) < 0) {
                countLower++;
            }
        }
        StringBuilder res = new StringBuilder();
        res.append("выше нуля: ").append(countUpper).append(", ");
        res.append("ниже нуля: ").append(countLower).append(", ");
        res.append("равна нулю: ").append(countZero);
        return res.toString();
    }
}


