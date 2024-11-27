package com.education.ztu;

import java.util.concurrent.Callable;

public class SumCalculator implements Callable<Long> {
    private final int[] numbers;
    private final int start;
    private final int end;

    public SumCalculator(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    public Long call() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += MainSumCalculator.sumDigits(numbers[i]);
        }
        return sum;
    }
}
