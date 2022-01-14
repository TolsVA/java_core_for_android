package com.geekbrains.lesson12;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

import static java.lang.System.currentTimeMillis;

public class MyThreadTest extends Thread{

    public synchronized float oneFlow(float[] arr) {
        System.out.println("Поток - " + Thread.currentThread().getId() + " запущен.");
        long a = currentTimeMillis();
        fillArray(arr);
        reassign(arr, 0, 1);
        System.out.println("Поток - " + Thread.currentThread().getId() + " завершил работу за " +
                (currentTimeMillis() - a) + " миллисекунд.");
        return (currentTimeMillis() - a);
    }

    public synchronized float twoFlows(float[] arr, int half, int r) {
        System.out.println("\nПоток - " + Thread.currentThread().getId() + " запущен.");
        long a = currentTimeMillis();
        fillArray(arr);
        float[] arr1 = new float[half];
        float[] arr2 = new float[half];
        System.arraycopy(arr, 0, arr1, 0, half);
        System.arraycopy(arr, half, arr2, 0, half);

        System.out.println("Основной поток запустил " + (r * 2) + " потока/ов.");

        CountDownLatch w = new CountDownLatch(r);
        for (int i = 0; i < r; i++) {
            int f = i;
            new Thread(() -> {
                System.out.println("Поток - " + Thread.currentThread().getId() + ".");
                reassign(arr1, f, r);
                w.countDown();
            }).start();

            new Thread(() -> {
                System.out.println("Поток - " + Thread.currentThread().getId() + ".");
                reassign(arr2, f, r);
                w.countDown();
            }).start();
        }

        try {
            w.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, half);
        System.arraycopy(arr2, 0, arr, half, half);

        System.out.println("Поток - " + Thread.currentThread().getId() + " завершил работу за " +
                (currentTimeMillis() - a) + " миллисекунд.");

        return (currentTimeMillis() - a);

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
    }
}
