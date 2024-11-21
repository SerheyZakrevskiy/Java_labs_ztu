package com.education.ztu;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть перше число: ");
        int num1 = scanner.nextInt();

        System.out.print("Введіть друге число: ");
        int num2 = scanner.nextInt();

        if (num1 <= 0 || num2 <= 0) {
            System.out.println("Числа повинні бути додатними!");
        } else {
            int gcd = findGCD(num1, num2);
            System.out.println("Найбільший спільний дільник: " + gcd);
        }
    }

    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
