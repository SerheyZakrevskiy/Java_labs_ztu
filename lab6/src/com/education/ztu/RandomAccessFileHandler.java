package com.education.ztu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileHandler {

    private static final String FILE_PATH = "directory_for_files/products.txt";

    public static void modifyFile() {
        try (RandomAccessFile raf = new RandomAccessFile(FILE_PATH, "rw")) {
            System.out.println("Початковий вміст файлу:");
            displayFileContent();

            raf.seek(0); // Позиція на початку
            String newProduct1 = "Laptop - 1500 USD\n";
            insertText(raf, newProduct1);

            long middle = raf.length() / 2;
            raf.seek(middle);
            String newProduct2 = "Smartphone - 800 USD\n";
            insertText(raf, newProduct2);

            raf.seek(raf.length());
            String newProduct3 = "Tablet - 600 USD\n";
            raf.writeBytes(newProduct3);

            System.out.println("\nЗмінений вміст файлу:");
            displayFileContent();

        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Помилка під час роботи з файлом: " + e.getMessage());
        }
    }

    private static void displayFileContent() {
        try (RandomAccessFile raf = new RandomAccessFile(FILE_PATH, "r")) {
            String line;
            while ((line = raf.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Помилка читання файлу: " + e.getMessage());
        }
    }

    private static void insertText(RandomAccessFile raf, String text) throws IOException {
        long currentPos = raf.getFilePointer();
        byte[] remainingBytes = new byte[(int) (raf.length() - currentPos)];
        raf.readFully(remainingBytes);

        raf.seek(currentPos);
        raf.writeBytes(text);
        raf.write(remainingBytes);
    }
}
