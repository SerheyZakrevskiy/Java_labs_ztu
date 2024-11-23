package com.education.ztu;

import java.text.NumberFormat;
import java.util.*;

public class ReceiptPrinterTask {

    public static void printLocalizedReceipt(Locale locale) {
        // Отримуємо ResourceBundle для вибраної локалі
        ResourceBundle bundle = ResourceBundle.getBundle("data", locale);

        // Встановлюємо валютний формат для локалі
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);

        // Дата покупки
        String date = "28.03.2019 13:25:12";

        // Список товарів
        List<Product> products = new ArrayList<>();
        products.add(new Product("Jeans", "Women's Clothing", 1500.78));
        products.add(new Product("Skirt", "Women's Clothing", 1000.56));
        products.add(new Product("Tie", "Men's Clothing", 500.78));
        products.add(new Product("Shirt", "Men's Clothing", 700.25));
        products.add(new Product("Jacket", "Women's Clothing", 3200.00));

        // Заголовок
        System.out.println(bundle.getString("receipt.title"));
        System.out.println(bundle.getString("receipt.date") + " " + date);
        System.out.println("=========================================");
        System.out.println(bundle.getString("receipt.header"));
        System.out.println("=========================================");

        // Виведення товарів
        double total = 0.0;
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.printf("%-3d %-15s %-20s %10s%n",
                    i + 1,
                    product.getName(),
                    product.getCategory(),
                    currencyFormat.format(product.getPrice()));
            total += product.getPrice();
        }

        // Підвал чека
        System.out.println("=========================================");
        System.out.println(bundle.getString("receipt.footer") + " " + currencyFormat.format(total));
    }

    // Клас Product
    static class Product {
        private final String name;
        private final String category;
        private final double price;

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
