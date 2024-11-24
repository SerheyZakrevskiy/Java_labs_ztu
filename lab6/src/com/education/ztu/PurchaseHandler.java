package com.education.ztu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseHandler {

    private static final String FILE_PATH = "directory_for_files/purchase_report.txt";

    public static void generateReport(List<Product> products) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(FILE_PATH);

            double totalCost = 0;
            for (Product product : products) {
                writer.write(product.toString() + "\n");
                totalCost += product.getTotalCost();
            }

            writer.write(String.format("\nЗагальна вартість покупок: %.2f\n", totalCost));
            System.out.println("Звіт успішно записано у файл!");

        } catch (IOException e) {
            System.out.println("Помилка запису у файл: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Помилка закриття файлу: " + e.getMessage());
                }
            }
        }
    }

    public static void displayReport() {
        FileReader reader = null;
        BufferedReader bufferedReader = null;
        try {
            reader = new FileReader(FILE_PATH);
            bufferedReader = new BufferedReader(reader);

            String line;
            System.out.println("Звіт про покупки:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Помилка читання з файлу: " + e.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("Помилка закриття BufferedReader: " + e.getMessage());
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Помилка закриття FileReader: " + e.getMessage());
                }
            }
        }
    }
}
