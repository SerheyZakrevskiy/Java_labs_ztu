package com.education.ztu;

import java.util.function.Function;

public class Task3d {
    public static void main(String[] args) {
        Function<String, Integer> multiplyNumbers = s -> {
            String[] numbers = s.split("\\s+");
            int product = 1;
            for (String num : numbers) {
                product *= Integer.parseInt(num);
            }
            return product;
        };

        String input = "2 3 4";
        System.out.println("Добуток чисел: " + multiplyNumbers.apply(input)); // 24
    }
}
