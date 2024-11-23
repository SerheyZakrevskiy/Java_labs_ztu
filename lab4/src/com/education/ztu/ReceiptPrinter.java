package com.education.ztu;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class ReceiptPrinter {

    public static void printReceipt() {
        String date = "28.03.2019 13:25:12";

        List<Product> products = new ArrayList<>();
        products.add(new Product("Джинси", "Жіночий одяг", 1500.78));
        products.add(new Product("Спідниця", "Жіночий одяг", 1000.56));
        products.add(new Product("Краватка", "Чоловічий одяг", 500.78));

        products.add(new Product("Сорочка", "Чоловічий одяг", 700.25));
        products.add(new Product("Куртка", "Жіночий одяг", 3200.00));
        products.add(new Product("Кросівки", "Взуття", 2500.50));
        products.add(new Product("Чоботи", "Взуття", 3400.99));
        products.add(new Product("Сумка", "Аксесуари", 1200.00));
        products.add(new Product("Годинник", "Аксесуари", 5000.75));
        products.add(new Product("Шарф", "Аксесуари", 450.30));

        Formatter formatter = new Formatter();
        double total = 0.0;

        formatter.format("Дата та час покупки: %s%n", date);
        formatter.format("=========================================%n");
        formatter.format("%-3s %-15s %-20s %10s%n", "№", "Товар", "Категорія", "Ціна");
        formatter.format("=========================================%n");

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            formatter.format("%-3d %-15s %-20s %10.2f ₴%n", i + 1, product.getName(), product.getCategory(), product.getPrice());
            total += product.getPrice();
        }

        formatter.format("=========================================%n");
        formatter.format("Разом: %34.2f ₴%n", total);

        System.out.println(formatter);
        formatter.close();
    }

    static class Product {
        private String name;
        private String category;
        private double price;

        public Product(String name, String category, double price) {
            this.name = name;
            this.category = category;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }
    }
}
