package com.education.ztu;

import java.util.*;
import java.util.stream.Collectors;

public class MainProduct {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Dell", 1200.50, 10),
                new Product("Phone", "Apple", 999.99, 15),
                new Product("Tablet", "Samsung", 800.00, 20),
                new Product("Monitor", "LG", 300.00, 12),
                new Product("Keyboard", "Logitech", 50.00, 50),
                new Product("Mouse", "Logitech", 25.00, 100)
        );

        System.out.println("Бренди:");
        products.stream()
                .map(Product::getBrand)
                .distinct()
                .forEach(System.out::println);

        System.out.println("\nТовари з ціною менше 1000:");
        products.stream()
                .filter(p -> p.getPrice() < 1000)
                .limit(2)
                .forEach(System.out::println);

        int totalCount = products.stream()
                .map(Product::getCount)
                .reduce(0, Integer::sum);
        System.out.println("\nСума всіх видів товарів на складі: " + totalCount);

        System.out.println("\nТовари, згруповані по бренду:");
        Map<String, List<Product>> groupedByBrand = products.stream()
                .collect(Collectors.groupingBy(Product::getBrand));
        groupedByBrand.forEach((brand, productList) -> {
            System.out.println("Бренд: " + brand);
            productList.forEach(System.out::println);
        });

        System.out.println("\nТовари, відсортовані за ціною:");
        List<Product> sortedByPrice = products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());
        sortedByPrice.forEach(System.out::println);
    }
}
