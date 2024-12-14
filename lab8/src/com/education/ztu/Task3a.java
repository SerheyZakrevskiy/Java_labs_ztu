package com.education.ztu;

import java.util.function.Predicate;

public class Task3a {
    public static void main(String[] args) {
        Predicate<String> isNumeric = s -> {
            try {
                Double.parseDouble(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };

        Predicate<String> isNotEmpty = s -> !s.isEmpty();
        Predicate<String> isValidNumber = isNumeric.and(isNotEmpty);

        String input1 = "123.45";
        String input2 = "Hello";
        System.out.println("Чи можна привести до числа (123.45): " + isValidNumber.test(input1));
        System.out.println("Чи можна привести до числа (Hello): " + isValidNumber.test(input2));
    }
}
