package com.education.ztu;

import java.util.Random;
import java.util.concurrent.*;

public class MainSumCalculator {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final int ARRAY_SIZE = 1_000_000;
        final int THREAD_COUNT = 5;

        int[] numbers = generateRandomArray(ARRAY_SIZE);

        long startSingleThread = System.currentTimeMillis();
        long singleThreadSum = calculateSumSingleThread(numbers);
        long endSingleThread = System.currentTimeMillis();
        System.out.println("Однопотокова сума: " + singleThreadSum);
        System.out.println("Час виконання (однопотоковий): " + (endSingleThread - startSingleThread) + " мс");

        long startMultiThread = System.currentTimeMillis();
        long multiThreadSum = calculateSumMultiThread(numbers, THREAD_COUNT);
        long endMultiThread = System.currentTimeMillis();
        System.out.println("Багатопотокова сума: " + multiThreadSum);
        System.out.println("Час виконання (багатопотоковий): " + (endMultiThread - startMultiThread) + " мс");
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100); // Генеруємо числа від 0 до 99
        }
        return array;
    }

    public static long calculateSumSingleThread(int[] numbers) {
        long sum = 0;
        for (int num : numbers) {
            sum += sumDigits(num);
        }
        return sum;
    }

    public static long calculateSumMultiThread(int[] numbers, int threadCount) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        int chunkSize = numbers.length / threadCount;
        Future<Long>[] futures = new Future[threadCount];

        for (int i = 0; i < threadCount; i++) {
            int start = i * chunkSize;
            int end = (i == threadCount - 1) ? numbers.length : start + chunkSize;
            futures[i] = executor.submit(new SumCalculator(numbers, start, end));
        }

        long totalSum = 0;
        for (Future<Long> future : futures) {
            totalSum += future.get();
        }

        executor.shutdown();
        return totalSum;
    }

    public static int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
