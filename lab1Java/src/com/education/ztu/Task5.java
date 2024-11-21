package com.education.ztu;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть ціле додатне число: ");
        int number = scanner.nextInt();

        if (number < 0) {
            System.out.println("Число повинно бути додатним!");
        } else {
            int sum = calculateDigitSum(number);
            System.out.println("Сума цифр числа: " + sum);
        }
    }

    public static int calculateDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}

