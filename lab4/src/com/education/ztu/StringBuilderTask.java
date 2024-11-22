package com.education.ztu;

public class StringBuilderTask {
    public static void run() {
        int num1 = 4;
        int num2 = 36;

        StringBuilder sb = new StringBuilder();
        sb.append(num1).append(" + ").append(num2).append(" = ").append(num1 + num2);
        System.out.println("Addition: " + sb);

        sb.insert(sb.indexOf("="), "рівно");
        sb.deleteCharAt(sb.indexOf("="));
        System.out.println("Replaced '=' with 'рівно' (insert + deleteCharAt): " + sb);

        sb.setLength(0);
        sb.append(num1).append(" - ").append(num2).append(" = ").append(num1 - num2);
        System.out.println("Subtraction: " + sb);

        int equalIndex = sb.indexOf("=");
        sb.replace(equalIndex, equalIndex + 1, "рівно");
        System.out.println("Replaced '=' with 'рівно' (replace): " + sb);

        sb.setLength(0);
        sb.append(num1).append(" * ").append(num2).append(" = ").append(num1 * num2);
        System.out.println("Multiplication: " + sb);

        sb.reverse();
        System.out.println("Reversed: " + sb);

        System.out.println("Length: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());
    }
}
