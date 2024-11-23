package com.education.ztu;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {

    public static void execute() {
        Map<String, Product> productMap = new HashMap<>();

        productMap.put("Jeans", new Product("Jeans", "Clothing", 1500.50, 10));
        productMap.put("T-shirt", new Product("T-shirt", "Clothing", 500.75, 25));
        productMap.put("Sneakers", new Product("Sneakers", "Shoes", 2500.00, 5));
        System.out.println("Map після додавання елементів:");
        printMap(productMap);

        System.out.println("\nЕлемент з ключем 'T-shirt': " + productMap.get("T-shirt"));


        System.out.println("Чи містить ключ 'Jeans'? " + productMap.containsKey("Jeans"));
        System.out.println("Чи містить значення для продукту 'Sneakers'? " +
                productMap.containsValue(new Product("Sneakers", "Shoes", 2500.00, 5)));

        productMap.putIfAbsent("Jacket", new Product("Jacket", "Clothing", 3000.00, 8));
        System.out.println("\nMap після putIfAbsent:");
        printMap(productMap);

        System.out.println("\nКлючі в Map:");
        for (String key : productMap.keySet()) {
            System.out.println(key);
        }

        System.out.println("\nЗначення в Map:");
        for (Product product : productMap.values()) {
            System.out.println(product);
        }

        Map<String, Product> newProducts = new HashMap<>();
        newProducts.put("Scarf", new Product("Scarf", "Accessories", 300.00, 15));
        newProducts.put("Hat", new Product("Hat", "Accessories", 200.00, 20));
        productMap.putAll(newProducts);
        System.out.println("\nMap після putAll:");
        printMap(productMap);

        productMap.remove("T-shirt");
        System.out.println("\nMap після видалення ключа 'T-shirt':");
        printMap(productMap);

        System.out.println("\nРозмір Map: " + productMap.size());

        System.out.println("\nРобота з entrySet:");
        Set<Map.Entry<String, Product>> entries = productMap.entrySet();
        for (Map.Entry<String, Product> entry : entries) {
            System.out.println("Ключ: " + entry.getKey() + ", Значення: " + entry.getValue());
            entry.setValue(new Product(entry.getKey(), entry.getValue().getCategory(),
                    entry.getValue().getPrice() + 100, entry.getValue().getQuantity()));
        }
        System.out.println("\nMap після змін через entrySet:");
        printMap(productMap);

        productMap.clear();
        System.out.println("\nMap після очищення:");
        System.out.println("Порожня? " + productMap.isEmpty());
    }

    private static void printMap(Map<String, Product> map) {
        for (Map.Entry<String, Product> entry : map.entrySet()) {
            System.out.println("Ключ: " + entry.getKey() + ", Значення: " + entry.getValue());
        }
    }
}
