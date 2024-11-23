package com.education.ztu;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueDemo {

    public static void execute() {
        Deque<Product> productQueue = new ArrayDeque<>();

        productQueue.offerLast(new Product("Jeans", "Clothing", 1500.50, 10));
        productQueue.offerLast(new Product("T-shirt", "Clothing", 500.75, 25));
        productQueue.offerLast(new Product("Sneakers", "Shoes", 2500.00, 5));
        System.out.println("Черга після додавання елементів:");
        printQueue(productQueue);

        productQueue.push(new Product("Jacket", "Clothing", 3000.00, 8));
        System.out.println("\nЧерга після додавання елемента на початок:");
        printQueue(productQueue);

        System.out.println("\nПерший елемент: " + productQueue.getFirst());
        System.out.println("Останній елемент: " + productQueue.peekLast());

        Product removedFirst = productQueue.pop();
        System.out.println("\nВидалено перший елемент: " + removedFirst);
        System.out.println("Черга після видалення першого елемента:");
        printQueue(productQueue);

        Product removedLast = productQueue.removeLast();
        System.out.println("\nВидалено останній елемент: " + removedLast);
        System.out.println("Черга після видалення останнього елемента:");
        printQueue(productQueue);

        productQueue.offerLast(new Product("Scarf", "Accessories", 300.00, 15));
        System.out.println("\nЧерга після додавання 'Scarf':");
        printQueue(productQueue);

        Product polledLast = productQueue.pollLast();
        System.out.println("\nВидалено останній елемент (pollLast): " + polledLast);
        System.out.println("Черга після pollLast:");
        printQueue(productQueue);

        System.out.println("\nРозмір черги: " + productQueue.size());

        productQueue.clear();
        System.out.println("\nЧерга після очищення:");
        System.out.println("Порожня? " + productQueue.isEmpty());
    }

    private static void printQueue(Deque<Product> queue) {
        for (Product product : queue) {
            System.out.println(product);
        }
    }
}
