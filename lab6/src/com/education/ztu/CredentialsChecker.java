package com.education.ztu;

public class CredentialsChecker {

    public static boolean checkCredentials(String login, String password, String confirmPassword) {
        try {
            if (login == null || !login.matches("[A-Za-z0-9_]+") || login.length() >= 20) {
                throw new WrongLoginException("Логін має містити лише латинські літери, цифри та знак підкреслення і бути меншим за 20 символів.");
            }

            if (password == null || !password.matches("[A-Za-z0-9_]+") || password.length() >= 20) {
                throw new WrongPasswordException("Пароль має містити лише латинські літери, цифри та знак підкреслення і бути меншим за 20 символів.");
            }

            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароль і підтвердження паролю не збігаються.");
            }

            System.out.println("Перевірка пройдена успішно!");
            return true;

        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Помилка: " + e.getMessage());
            return false;
        }
    }
}
