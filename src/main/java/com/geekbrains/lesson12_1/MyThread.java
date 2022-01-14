package com.geekbrains.lesson12_1;

import java.util.Arrays;

import static java.lang.System.currentTimeMillis;

public class MyThread extends Thread{
    final int SIZE = 10000000;
    final int HALF = SIZE/2;
    private final float[] arr = new float[SIZE];
    private final float[] s = {0};
    private final float[] b = {0};
    private final Object lock = new Object();
    private final Object lock1 = new Object();
    private int counter = 0;
    private final int threadCount = 2;

    @Override
    public void run() {
        new Thread(() -> oneFlow(arr)).start();

        new Thread(() -> twoFlows(arr, HALF, threadCount)).start();

        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\nПроизводительность увеличена в " +
                    (s[0] / b[0]) + " раз.");
        }
    }

    public synchronized void oneFlow(float[] arr) {
        System.out.println("Поток - " + Thread.currentThread().getId() + " запущен.");
        long a = currentTimeMillis();
        fillArray(arr);
        reassign(arr, 0, 1);
        s[0] = currentTimeMillis() - a;
        System.out.println("Поток - " + Thread.currentThread().getId() + " завершил работу за " +
                s[0] + " миллисекунд.");
    }

    public synchronized void twoFlows(float[] arr, int half, int r) {
        System.out.println("\nПоток - " + Thread.currentThread().getId() + " запущен.");
        long a = currentTimeMillis();
        fillArray(arr);
        float[] arr1 = new float[half];
        float[] arr2 = new float[half];
        System.arraycopy(arr, 0, arr1, 0, half);
        System.arraycopy(arr, half, arr2, 0, half);

        System.out.println("Поток " + Thread.currentThread().getId() +" запустил " + (r * 2) + " потока/ов.");

        for (int i = 0; i < r; i++) {
            int f = i;
            new Thread(() -> {
                System.out.println("Поток - " + Thread.currentThread().getId() + ".");
                reassign(arr1, f, r);
            }).start();

            new Thread(() -> {
                System.out.println("Поток - " + Thread.currentThread().getId() + ".");
                reassign(arr2, f, r);
            }).start();
        }
        synchronized (lock1) {
            try {
                lock1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.arraycopy(arr1, 0, arr, 0, half);
            System.arraycopy(arr2, 0, arr, half, half);

            System.out.println("Поток - " + Thread.currentThread().getId() + " завершил работу за " +
                    (currentTimeMillis() - a) + " миллисекунд.");

            b[0] = currentTimeMillis() - a;

            synchronized (lock) {
                lock.notify();
            }
        }
    }

    private void fillArray(float[] arr) {
        long a = currentTimeMillis();
        Arrays.fill(arr,1);
        System.out.println("Время заполнения Arrays.fill(arr, 1) - " + (currentTimeMillis() - a) + " миллисекунд.");
    }

    private void reassign(float[] arr, int s, int j) {
        long a = currentTimeMillis();
        for (int i = s; i < arr.length; i = i + j) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (float)i / 5) * Math.cos(0.2f + (float)i / 5) * Math.cos(0.4f + (float)i / 2));
        }

        System.out.println("Время заполнения массива расчетными данными " + (currentTimeMillis() - a) + " миллисекунд.");

        counter++;
        if (counter == ((threadCount * 2) + 1)) {
            synchronized (lock1) {
                lock1.notify();
            }
        }
    }
}
