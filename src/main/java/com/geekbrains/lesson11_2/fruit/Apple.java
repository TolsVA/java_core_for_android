package com.geekbrains.lesson11_2.fruit;

public class Apple extends Fruit {

    public Apple() {
        setName("яблок");
        setWeight((float) ((float) ((int) (Math.random() * 9) + 1)/10 + 0.4));
    }

    @Override
    public String toString() {
        return "[Яблоко   вес: " + getWeight() + "]";
    }
}
