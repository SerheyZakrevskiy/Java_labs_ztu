package com.education.ztu;

import java.io.File;

public class FileHandler {

    private static final String DIRECTORY_PATH = "directory_for_files";

    public static void ensureDirectoryExists() {
        File directory = new File(DIRECTORY_PATH);
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Папку directory_for_files успішно створено.");
            } else {
                System.out.println("Не вдалося створити папку directory_for_files.");
            }
        } else {
            System.out.println("Папка directory_for_files вже існує.");
        }
    }
}
