package com.education.ztu;

import java.util.regex.*;
import java.util.*;
import java.lang.annotation.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Lab 9: Regular Expressions, Reflection, and Annotations");


        System.out.println("\n--- Task 2: Regular Expressions ---");
        String text = """
            John Doe, 30, Developer, 5 years, 123 Main St, john.doe@example.com, +123-456-7890
            Jane Smith, 25, Designer, 3 years, 456 Maple Ave, jane.smith@workmail.com, +987-654-3210
            Bob Brown, 40, Manager, 10 years, 789 Elm Rd, bob.brown@company.com, +111-222-3333
        """;

        System.out.println("Original Text:\n" + text);


        Pattern phonePattern = Pattern.compile("\\+\\d{3}-\\d{3}-\\d{4}");
        Matcher phoneMatcher = phonePattern.matcher(text);
        System.out.println("\nPhone Numbers:");
        while (phoneMatcher.find()) {
            System.out.println(phoneMatcher.group());
        }


        Pattern emailPattern = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,7}\\b");
        Matcher emailMatcher = emailPattern.matcher(text);
        System.out.println("\nEmails:");
        while (emailMatcher.find()) {
            System.out.println(emailMatcher.group());
        }


        System.out.println("\n--- Task 3: Reflection ---");
        ReflectionExample.runReflectionDemo();


        System.out.println("\n--- Task 4: Custom Annotations ---");
        AnnotationExample.runAnnotationDemo();
    }
}


class ReflectionExample {
    public static void runReflectionDemo() {
        try {
            Class<?> clazz = CustomClass.class;

            System.out.println("Class Name: " + clazz.getName());

            System.out.println("\nFields:");
            Arrays.stream(clazz.getDeclaredFields()).forEach(field -> {
                System.out.println(" - " + field.getName() + " (" + field.getType().getSimpleName() + ")");
            });

            System.out.println("\nMethods:");
            Arrays.stream(clazz.getDeclaredMethods()).forEach(method -> {
                System.out.println(" - " + method.getName());
            });


            CustomClass instance = (CustomClass) clazz.getDeclaredConstructor().newInstance();
            System.out.println("\nInstance created: " + instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class CustomClass {
    private String name = "Default Name";
    public int age;

    public CustomClass() {
        this.age = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface CustomAnnotation {
    String author() default "Anonymous";
    String date();
}

@CustomAnnotation(author = "Student", date = "2024-12-14")
class AnnotationExample {
    public static void runAnnotationDemo() {
        Class<AnnotationExample> clazz = AnnotationExample.class;
        CustomAnnotation annotation = clazz.getAnnotation(CustomAnnotation.class);

        if (annotation != null) {
            System.out.println("Author: " + annotation.author());
            System.out.println("Date: " + annotation.date());
        }
    }
}
