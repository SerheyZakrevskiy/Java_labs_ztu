package com.education.ztu;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть логін: ");
        String login = scanner.nextLine();

        System.out.print("Введіть пароль: ");
        String password = scanner.nextLine();

        System.out.print("Підтвердіть пароль: ");
        String confirmPassword = scanner.nextLine();

        boolean isValid = CredentialsChecker.checkCredentials(login, password, confirmPassword);

        if (isValid) {
            System.out.println("Дані успішно перевірено!");
        } else {
            System.out.println("Дані містять помилки!");
        }

        List<Product> products = new ArrayList<>();
        products.add(new Product("Jeans", 1500.50, 2));
        products.add(new Product("T-shirt", 500.75, 3));
        products.add(new Product("Sneakers", 2500.00, 1));

        System.out.println("Запис звіту у файл...");
        PurchaseHandler.generateReport(products);

        System.out.println("\nЧитання звіту з файлу:");
        PurchaseHandler.displayReport();

        String sourceTextFile = "directory_for_files/source_text.txt";
        String destTextFile = "directory_for_files/copied_text.txt";

        String sourceImageFile = "directory_for_files/source_image.jpg";
        String destImageFile = "directory_for_files/copied_image.jpg";

        System.out.println("Копіювання текстового файлу...");
        FileCopier.copyTextFile(sourceTextFile, destTextFile);

        System.out.println("\nКопіювання бінарного файлу (зображення)...");
        FileCopier.copyBinaryFile(sourceImageFile, destImageFile);

        System.out.println("Демонстрація роботи з RandomAccessFile:");
        RandomAccessFileHandler.modifyFile();

        System.out.println("Демонстрація роботи з класом File:");
        FileOperations.execute();

        System.out.println("Створення архіву...");
        ZipHandler.createZipArchive();

        System.out.println("\nВиведення списку файлів з архіву...");
        ZipHandler.listFilesInArchive();
    }
}
