package com.geekbrains.lesson13;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static CyclicBarrier cd = new CyclicBarrier(CARS_COUNT);
    public static Semaphore semaphore = new Semaphore(CARS_COUNT/2);
    public static CountDownLatch cdStart = new CountDownLatch(CARS_COUNT);
    public static CountDownLatch cdFinish = new CountDownLatch(CARS_COUNT);
    public static Lock lock = new ReentrantLock();
    public static long time;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        System.out.println();
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
            new Thread((cars[i])).start();
        }
        try {
            cdStart.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        System.out.println();
        try {
            cdFinish.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}

