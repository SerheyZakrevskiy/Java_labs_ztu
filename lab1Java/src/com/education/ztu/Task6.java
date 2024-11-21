package com.education.ztu;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть розмір масиву (n): ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Розмір масиву повинен бути додатним!");
        } else {
            int[] fibonacci = new int[n];
            fibonacci[0] = 1;
            if (n > 1) {
                fibonacci[1] = 1;
            }

            for (int i = 2; i < n; i++) {
                fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            }

            int[] reverseFibonacci = new int[n];
            for (int i = 0; i < n; i++) {
                reverseFibonacci[i] = fibonacci[n - 1 - i];
            }

            System.out.print("Послідовність Фібоначчі: ");
            printArray(fibonacci);

            System.out.print("Зворотня послідовність: ");
            printArray(reverseFibonacci);
        }
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

