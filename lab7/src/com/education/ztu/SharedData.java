package com.education.ztu;

public class SharedData {
    private String data = "";
    private boolean isReady = false;

    public synchronized void write(String input) {
        while (isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Writer потік перервано!");
            }
        }
        data = input;
        isReady = true;
        notify();
    }

    public synchronized String read() {
        while (!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Printer потік перервано!");
            }
        }
        isReady = false;
        notify();
        return data;
    }
}
