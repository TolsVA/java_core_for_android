package com.geekbrains.lesson7.Animal;

public abstract class Bird extends Animal {
    protected int flight;    // Полёт
    public Bird() {

    }


    public abstract int getRun();

    public abstract double getRunSpeed();

    public abstract double getRunTime(double d, double b);
}
