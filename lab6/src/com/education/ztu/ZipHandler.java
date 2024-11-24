package com.education.ztu;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipHandler {

    private static final String DIRECTORY_PATH = "directory_for_files";
    private static final String ZIP_FILE_PATH = DIRECTORY_PATH + "/archive.zip";

    public static void createZipArchive() {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(ZIP_FILE_PATH))) {
            File directory = new File(DIRECTORY_PATH);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (!file.isDirectory()) { // Архівуємо тільки файли
                        try (FileInputStream fis = new FileInputStream(file)) {
                            ZipEntry entry = new ZipEntry(file.getName());
                            zos.putNextEntry(entry);

                            byte[] buffer = new byte[1024];
                            int length;
                            while ((length = fis.read(buffer)) > 0) {
                                zos.write(buffer, 0, length);
                            }

                            zos.closeEntry();
                            System.out.println("Додано до архіву: " + file.getName());
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Помилка створення архіву: " + e.getMessage());
        }
    }

    public static void listFilesInArchive() {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(ZIP_FILE_PATH))) {
            ZipEntry entry;
            System.out.println("Список файлів у архіві:");
            while ((entry = zis.getNextEntry()) != null) {
                System.out.println("Файл: " + entry.getName());
                zis.closeEntry();
            }
        } catch (IOException e) {
            System.out.println("Помилка читання архіву: " + e.getMessage());
        }
    }
}
