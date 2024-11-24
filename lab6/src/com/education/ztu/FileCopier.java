package com.education.ztu;

import java.io.*;

public class FileCopier {

    public static void copyTextFile(String sourcePath, String destPath) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
                BufferedWriter writer = new BufferedWriter(new FileWriter(destPath))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Текстовий файл успішно скопійовано!");

        } catch (IOException e) {
            System.out.println("Помилка під час копіювання текстового файлу: " + e.getMessage());
        }
    }

    public static void copyBinaryFile(String sourcePath, String destPath) {
        try (
                FileInputStream inputStream = new FileInputStream(sourcePath);
                FileOutputStream outputStream = new FileOutputStream(destPath)
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("Бінарний файл успішно скопійовано!");

        } catch (IOException e) {
            System.out.println("Помилка під час копіювання бінарного файлу: " + e.getMessage());
        }
    }
}
