package com.geekbrains.lesson6.Animal;

public class Cat extends Animal {
    private static int z;
    public static String lainCatName = "Вася, Вирус, Ватсон, Барсик, Пушок, Хася, Проша, Кузя, Стёпа, Хусейн, Мурзик";
    public Cat() {

    }

    @Override
    public int getRun() {
        run =  (((int) (Math.random() * 5)) * 10) + 150;
        return run;
    }

    @Override
    public double getRunSpeed() {
        runSpeed = ((int) (Math.random() * 10)) + 30;
        return runSpeed;
    }
    @Override
    public double getRunTime(double d, double b) {
        runTime = d/b;
        return runTime;
    }

    @Override
    public Animal clone() {
        Cat cat = new Cat();
        cat.name = "Кличка:            - " + lainCatName.split(", ")[(int) Math.round(Math.random() * (lainCatName.split(", ").length - 1))];
        z++;
        cat.counter = z;
        return cat;
    }

    @Override
    public String getVoice() {
        voice = " - cat meows - (Мew! Мew! Мew!)";
        return voice;
    }

    @Override
    public int getClassAnimail() {
        classAnimail = 2;
        return classAnimail;
    }

    @Override
    public String getKindOfAnimal() {
        kindOfAnimal = "Кот:    ";
        return kindOfAnimal;
    }

}
