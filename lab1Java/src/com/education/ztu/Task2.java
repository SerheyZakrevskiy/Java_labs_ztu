package com.education.ztu;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть перше число: ");
        int num1 = scanner.nextInt();
        System.out.print("Введіть друге число: ");
        int num2 = scanner.nextInt();
        System.out.println("Сума: " + (num1 + num2));
    }
}
