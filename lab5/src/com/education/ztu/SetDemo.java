package com.education.ztu;

import java.util.NavigableSet;
import java.util.TreeSet;

public class SetDemo {

    public static void execute() {
        TreeSet<Product> productSet = new TreeSet<>((p1, p2) -> p1.getName().compareTo(p2.getName()));

        productSet.add(new Product("Jeans", "Clothing", 1500.50, 10));
        productSet.add(new Product("T-shirt", "Clothing", 500.75, 25));
        productSet.add(new Product("Sneakers", "Shoes", 2500.00, 5));
        productSet.add(new Product("Jacket", "Clothing", 3000.00, 8));
        productSet.add(new Product("Scarf", "Accessories", 300.00, 15));
        System.out.println("Множина після додавання елементів:");
        printSet(productSet);

        System.out.println("\nПерший елемент: " + productSet.first());
        System.out.println("Останній елемент: " + productSet.last());

        System.out.println("\nЕлементи, що менші за 'Jacket' (headSet):");
        printSet(productSet.headSet(new Product("Jacket", "", 0, 0)));

        System.out.println("\nЕлементи між 'Jeans' та 'Sneakers' (subSet):");
        printSet(productSet.subSet(new Product("Jeans", "", 0, 0), new Product("Sneakers", "", 0, 0)));

        System.out.println("\nЕлементи, що більші або рівні 'T-shirt' (tailSet):");
        printSet(productSet.tailSet(new Product("T-shirt", "", 0, 0)));

        System.out.println("\nЕлемент, більший або рівний 'Jeans' (ceiling): " + productSet.ceiling(new Product("Jeans", "", 0, 0)));
        System.out.println("Елемент, менший або рівний 'Jacket' (floor): " + productSet.floor(new Product("Jacket", "", 0, 0)));
        System.out.println("Елемент, більший за 'Jeans' (higher): " + productSet.higher(new Product("Jeans", "", 0, 0)));
        System.out.println("Елемент, менший за 'Jacket' (lower): " + productSet.lower(new Product("Jacket", "", 0, 0)));

        Product firstProduct = productSet.pollFirst();
        System.out.println("\nВидалено перший елемент: " + firstProduct);
        Product lastProduct = productSet.pollLast();
        System.out.println("Видалено останній елемент: " + lastProduct);

        System.out.println("\nМножина після видалення першого та останнього елементів:");
        printSet(productSet);

        NavigableSet<Product> descendingSet = productSet.descendingSet();
        System.out.println("\nМножина у зворотному порядку:");
        printSet(descendingSet);
    }

    private static void printSet(Iterable<Product> set) {
        for (Product product : set) {
            System.out.println(product);
        }
    }
}
