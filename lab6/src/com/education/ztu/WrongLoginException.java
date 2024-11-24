package com.education.ztu;

public class WrongLoginException extends Exception {
    public WrongLoginException() {
        super("Невірний логін!");
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
