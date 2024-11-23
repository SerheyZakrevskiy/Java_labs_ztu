package com.education.ztu;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running Task 2:");
        StringTask.run();

        System.out.println("\nRunning Task 3:");
        StringBuilderTask.run();

        System.out.println("Чек на покупку:");
        ReceiptPrinter.printReceipt();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select language / Оберіть мову:");
        System.out.println("1 - Українська");
        System.out.println("2 - English");
        System.out.println("3 - Français");

        int choice = scanner.nextInt();
        Locale locale;

        switch (choice) {
            case 1 -> locale = new Locale("ua", "UA");
            case 2 -> locale = new Locale("en", "US");
            case 3 -> locale = new Locale("fr", "FR");
            default -> {
                System.out.println("Invalid choice, defaulting to English.");
                locale = new Locale("en", "US");


                System.out.println("Робота з датами:");
                DateTask.execute();
            }
        }
        ReceiptPrinterTask.printLocalizedReceipt(locale);

    }
}