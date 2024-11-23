package com.education.ztu;

import java.util.*;

public class CollectionsDemo {

    public static void execute() {
        List<String> items = new ArrayList<>(Arrays.asList("Jeans", "T-shirt", "Sneakers", "Jacket", "Scarf", "Hat"));
        System.out.println("Початковий список:");
        System.out.println(items);

        Collections.sort(items);
        System.out.println("\nПісля сортування:");
        System.out.println(items);

        int index = Collections.binarySearch(items, "Scarf");
        System.out.println("\nІндекс елемента 'Scarf' після сортування: " + index);

        Collections.reverse(items);
        System.out.println("\nПісля реверсу:");
        System.out.println(items);

        Collections.shuffle(items);
        System.out.println("\nПісля перемішування:");
        System.out.println(items);

        Collections.fill(items, "Default");
        System.out.println("\nПісля заповнення значенням 'Default':");
        System.out.println(items);

        List<Integer> numbers = Arrays.asList(5, 12, 1, 45, 23, 9);
        int max = Collections.max(numbers);
        int min = Collections.min(numbers);
        System.out.println("\nМасив чисел: " + numbers);
        System.out.println("Максимальне значення: " + max);
        System.out.println("Мінімальне значення: " + min);

        List<String> sourceList = new ArrayList<>(Arrays.asList("Jeans", "T-shirt", "Sneakers"));
        List<String> destinationList = new ArrayList<>(Arrays.asList("", "", ""));
        Collections.copy(destinationList, sourceList);
        System.out.println("\nСписок після копіювання:");
        System.out.println("Джерело: " + sourceList);
        System.out.println("Призначення: " + destinationList);

        List<String> rotateList = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
        Collections.rotate(rotateList, 2);
        System.out.println("\nСписок після ротації:");
        System.out.println(rotateList);


        Collection<String> checkedList = Collections.checkedCollection(new ArrayList<>(), String.class);
        checkedList.add("Valid");
        System.out.println("\nПеревірена колекція:");
        System.out.println(checkedList);

        List<String> freqList = Arrays.asList("Apple", "Banana", "Apple", "Orange", "Apple");
        int frequency = Collections.frequency(freqList, "Apple");
        System.out.println("\nЧастота елемента 'Apple': " + frequency);
    }
}
