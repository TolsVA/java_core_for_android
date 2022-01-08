package com.geekbrains.lesson11_2.fruit;

public class Orange extends Fruit{

    public Orange() {
        setName("апельсин");
        setWeight((float) ((int) (Math.random() * 9) + 1)/10 + 1);
    }

    @Override
    public String toString() {
        return "[Апельсин вес: " + getWeight() + "]";
    }
}
