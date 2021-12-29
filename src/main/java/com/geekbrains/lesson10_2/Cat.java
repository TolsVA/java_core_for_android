package com.geekbrains.lesson10_2;

public class Cat implements Comparable{
    private String name;
    private int age;
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        Cat another = (Cat)o;
        if (this.age > another.age) {
            return 1; }
        if (this.age < another.age) { return -1;
        }
        return 0; }

    @Override
    public String toString() {
        return "Cat [" + name + "]";
    }
}
