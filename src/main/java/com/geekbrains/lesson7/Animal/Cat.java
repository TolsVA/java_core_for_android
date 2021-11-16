package com.geekbrains.lesson7.Animal;

public class Cat extends Animal {
    private static int z;

    public Cat() {
        kindOfAnimal = "Кот:    ";
        counter = z;
        String lainCatName = "Вася, Вирус, Ватсон, Барсик, Пушок, Хася, Проша, Кузя, Стёпа, Хусейн, Мурзик";
        name = "Кличка:            - " + lainCatName.split(", ")[(int) Math.round(Math.random() *
                (lainCatName.split(", ").length - 1))];
        coatColor = lainColor.split(", ")[(int) Math.round(Math.random() * (lainColor.split(", ").length - 1))];
        age = ((int) Math.round(Math.random()*14) + 1);
        run =  (((int) (Math.random() * 5)) * 10) + 150;
        runSpeed = ((int) (Math.random() * 10)) + 30;
    }

    @Override
    public Cat clone() {
        z++;
        return new Cat();
    }

    @Override
    public String getVoice() {
        voice = " - cat meows - (Мew! Мew! Мew!)";
        return voice;
    }

    @Override
    public double getRunTime(double d, double b) {
        runTime = d / b;
        return runTime;
    }

    @Override
    public double getSwimmingTime(double d, double b) {
        swimmingTime = d / b;
        return swimmingTime;
    }

    @Override
    public int getClassAnimail() {
        classAnimail = 2;
        return classAnimail;
    }
}

