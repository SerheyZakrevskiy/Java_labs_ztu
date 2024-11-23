package com.education.ztu;

import java.util.*;

public class DynamicArrayDemo {

    public static void execute() {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Jeans", "Clothing", 1500.50, 10));
        products.add(new Product("T-shirt", "Clothing", 500.75, 25));
        products.add(new Product("Sneakers", "Shoes", 2500.00, 5));
        System.out.println("Список після додавання елементів:");
        printList(products);

        List<Product> newProducts = Arrays.asList(
                new Product("Jacket", "Clothing", 3000.00, 8),
                new Product("Scarf", "Accessories", 300.00, 15)
        );
        products.addAll(newProducts);
        System.out.println("\nСписок після додавання колекції:");
        printList(products);

        System.out.println("\nЕлемент на позиції 2: " + products.get(2));

        Product jeans = products.get(0);
        System.out.println("Індекс першого входження 'Jeans': " + products.indexOf(jeans));

        products.remove(1);
        System.out.println("\nСписок після видалення елемента на позиції 1:");
        printList(products);

        products.set(0, new Product("Hoodie", "Clothing", 800.00, 12));
        System.out.println("\nСписок після заміни першого елемента:");
        printList(products);

        System.out.println("\nЧи містить список 'Sneakers'? " + products.contains(new Product("Sneakers", "Shoes", 2500.00, 5)));

        products.sort(Comparator.comparing(Product::getName));
        System.out.println("\nСписок після сортування за назвою:");
        printList(products);

        List<Product> subList = products.subList(1, 3);
        System.out.println("\nПідсписок (елементи з 1 до 3):");
        printList(subList);

        Product[] productArray = products.toArray(new Product[0]);
        System.out.println("\nМасив елементів:");
        System.out.println(Arrays.toString(productArray));

        System.out.println("\nКількість елементів у списку: " + products.size());

        products.clear();
        System.out.println("\nСписок після очищення:");
        System.out.println("Порожній? " + products.isEmpty());
    }

    private static void printList(List<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
