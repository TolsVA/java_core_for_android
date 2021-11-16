package com.geekbrains.lesson6.Animal;

public class Cat extends Animal {
    private static int z = 1;
    private static final String lainCatColor = "Чёрный, Белый, Рыжий, Пятнистый, Полосатый";
    private static final String lainCatName = "Вася, Вирус, Ватсон, Барсик, Пушок, Хася, Проша, Кузя, Стёпа, Хусейн, Мурзик";

    public Cat() {
        setKindOfAnimal("Кот:    ");
        setCounter(z);
        setName("Кличка:            - " + lainCatName.split(", ")[(int) Math.round(Math.random() *
                (lainCatName.split(", ").length - 1))]);
        setVoice(" - cat meows - (Мew! Мew! Мew!)");
        setCoatColor(lainCatColor.split(", ")[(int) Math.round(Math.random() *
                (lainCatColor.split(", ").length - 1))]);
        setAge((int) Math.round(Math.random()*14) + 1);
        setRun((((int) (Math.random() * 5)) * 10) + 150);
        setRunSpeed((int) (Math.random() * 10) + 30);
        setSwimming(0);
        setSwimmingSpeed(0);
        setClassAnimail(2);
    }

    @Override
    public Cat clone() {
        Cat cat = new Cat();
        z++;
        return cat;
    }

}
