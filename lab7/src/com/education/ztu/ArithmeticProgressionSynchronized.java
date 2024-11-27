package com.education.ztu;

public class ArithmeticProgressionSynchronized implements Runnable {
    private static int result = 1;
    private static final int STEP = 1;
    private static final int LIMIT = 100;

    private static final Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (result > LIMIT) {
                    break;
                }
                System.out.print(result + " ");
                result += STEP;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ": Потік перервано!");
                break;
            }
        }
    }
}
