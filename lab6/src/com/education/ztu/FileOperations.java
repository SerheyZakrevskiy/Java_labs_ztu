package com.education.ztu;

import java.io.File;
import java.io.IOException;

public class FileOperations {

    private static final String BASE_DIRECTORY = "directory_for_files";
    private static final String INNER_DIRECTORY = "inner_directory";
    private static final String RENAMED_DIRECTORY = "renamed_inner_directory";

    public static void execute() {
        try {
            File innerDir = new File(BASE_DIRECTORY, INNER_DIRECTORY);
            if (innerDir.mkdir()) {
                System.out.println("Папка створена: " + innerDir.getAbsolutePath());
            } else {
                System.out.println("Не вдалося створити папку.");
            }

            System.out.println("Абсолютний шлях: " + innerDir.getAbsolutePath());

            System.out.println("Батьківська директорія: " + innerDir.getParent());

            File file1 = new File(innerDir, "file1.txt");
            File file2 = new File(innerDir, "file2.txt");

            if (file1.createNewFile()) {
                System.out.println("Файл створено: " + file1.getName());
            }
            if (file2.createNewFile()) {
                System.out.println("Файл створено: " + file2.getName());
            }

            if (file2.delete()) {
                System.out.println("Файл видалено: " + file2.getName());
            }

            File renamedDir = new File(BASE_DIRECTORY, RENAMED_DIRECTORY);
            if (innerDir.renameTo(renamedDir)) {
                System.out.println("Папка перейменована на: " + renamedDir.getName());
            } else {
                System.out.println("Не вдалося перейменувати папку.");
            }

            File baseDir = new File(BASE_DIRECTORY);
            System.out.println("\nСписок файлів та папок у " + baseDir.getName() + ":");
            File[] files = baseDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    System.out.printf("Ім'я: %s | Тип: %s | Розмір: %d байт\n",
                            file.getName(),
                            file.isDirectory() ? "Папка" : "Файл",
                            file.length());
                }
            }

        } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
