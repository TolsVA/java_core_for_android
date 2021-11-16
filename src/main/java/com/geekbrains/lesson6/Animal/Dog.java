package com.geekbrains.lesson6.Animal;

public class Dog extends Animal {
    private static int z = 1;
    private static final String lainDogColor = "Чёрный, Белый, Рыжий, Пятнистый";
    private static final String lainDogName = "Гром, Бакс, Чак, Гектор, Тузик, Бобик, Зевсе, Бим, Валет, Дружок";

    public Dog() {
        setKindOfAnimal("Собака: ");
        setCounter(z);
        setName("Кличка:            - " + lainDogName.split(", ")[(int) Math.round(Math.random() *
                (lainDogName.split(", ").length - 1))]);
        setVoice(" - cat meows - (Мew! Мew! Мew!)");
        setCoatColor(lainDogColor.split(", ")[(int) Math.round(Math.random() *
                (lainDogColor.split(", ").length - 1))]);
        setAge(((int) Math.round(Math.random()*14) + 1));
        setRun((((int) (Math.random() * 10)) * 10) + 400);
        setRunSpeed((int) (Math.random() * 10) + 30);
        setSwimming(((int) (Math.random() * 10)) + 10);
        setSwimmingSpeed((int) (Math.random() * 5) + 1);
        setClassAnimail(1);
    }

    @Override
    public Dog clone() {
        Dog dog = new Dog();
        z++;
        return dog;
    }
}
