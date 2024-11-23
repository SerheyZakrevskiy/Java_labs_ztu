package com.education.ztu;

import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class DateTask {

    public static void execute() {
        LocalDateTime labStart = LocalDateTime.of(2024, 11, 22, 10, 0, 0); // Ваша дата

        System.out.println("Дата початку лабораторної:");
        System.out.println("День тижня: " + labStart.getDayOfWeek());
        System.out.println("День у році: " + labStart.getDayOfYear());
        System.out.println("Місяць: " + labStart.getMonth());
        System.out.println("Рік: " + labStart.getYear());
        System.out.println("Години: " + labStart.getHour());
        System.out.println("Хвилини: " + labStart.getMinute());
        System.out.println("Секунди: " + labStart.getSecond());

        boolean isLeapYear = Year.isLeap(labStart.getYear());
        System.out.println("Рік високосний: " + (isLeapYear ? "Так" : "Ні"));

        LocalDateTime now = LocalDateTime.now();
        System.out.println("\nПоточний час:");
        System.out.println(now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));

        System.out.println("\nПорівняння дат:");
        System.out.println("Поточна дата після дати лабораторної? " + now.isAfter(labStart));
        System.out.println("Поточна дата до дати лабораторної? " + now.isBefore(labStart));

        LocalDateTime modifiedLabStart = labStart.plusDays(5).plusHours(2).minusMinutes(15);
        System.out.println("\nЗмінена дата та час лабораторної:");
        System.out.println(modifiedLabStart.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
    }
}
