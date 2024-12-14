package com.education.ztu;

import java.util.Optional;
import java.util.stream.IntStream;

public class MainOptional {
    public static void main(String[] args) {
        int[] numbers = {1, 5, 3, 9, 7};

        int[] emptyNumbers = {};

        String result1 = findMaxValue(numbers);
        System.out.println("Результат для заповненого масиву: " + result1);

        String result2 = findMaxValue(emptyNumbers);
        System.out.println("Результат для порожнього масиву: " + result2);
    }

    public static String findMaxValue(int[] numbers) {
        Optional<Integer> max = IntStream.of(numbers).boxed().max(Integer::compareTo);

        return max.map(String::valueOf).orElse("Числа відсутні");
    }
}
