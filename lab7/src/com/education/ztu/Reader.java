package com.education.ztu;

import java.util.Scanner;

public class Reader implements Runnable {
    private final SharedData sharedData;

    public Reader(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введіть текст (або 'exit' для завершення): ");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                sharedData.write("exit");
                break;
            }

            sharedData.write(input);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Reader потік перервано!");
            }
        }
        scanner.close();
    }
}
