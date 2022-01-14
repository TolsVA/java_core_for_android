package com.geekbrains.lesson12;

import java.util.concurrent.CountDownLatch;

public class MainClassThread extends Thread {
    static final int SIZE = 10000000;
    static final int HALF = SIZE/2;
    public static int threadCount = 2;

    public static void main (String[] args) {
        float[] a = {0};
        final float[] b = {0};
        float[] arr = new float[SIZE];

        MyThreadTest test = new MyThreadTest();

        CountDownLatch w = new CountDownLatch(threadCount);

        new Thread(() -> {
            a[0] = test.oneFlow(arr);
            w.countDown();
        }).start();
        new Thread(() -> {
            b[0] = test.twoFlows(arr, HALF, threadCount);
            w.countDown();
        }).start();

        try {
            w.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nПроизводительность увеличена в " +
                (Math.max(Math.abs(a[0]), Math.abs(b[0])) / Math.min(Math.abs(a[0]), Math.abs(b[0]))) + " раз.");
    }
}
