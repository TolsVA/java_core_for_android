package com.geekbrains.lesson7.Animal;

public class Fish extends Animal {
    private static int z;
    private static String lainDogName = "Адольф, Боря, Вини, Гарик, Джин, Ерик, Конфуций, Лунтик, Пират, Тики-тики, Уильям, Усач";
    public Fish() {

    }

    @Override
    public Fish clone() {
        Fish fish = new Fish();
        fish.name = "Кличка:            - " + lainDogName.split(", ")[(int) Math.round(Math.random() * (lainDogName.split(", ").length - 1))];
        z++;
        fish.counter = z;
        return fish;
    }

    @Override
    public int getSwimming() {
        swimming = (((int) (Math.random() * 10)) * 10) + 400;
        return swimming;
    }

    @Override
    public double getSwimmingSpeed() {
        swimmingSpeed = ((int) (Math.random() * 10)) + 150;
        return swimmingSpeed;
    }

    @Override
    public double getSwimmingTime(double d, double b) {
        swimmingTime = d / b;
        return swimmingTime;
    }

    @Override
    public String getVoice() {
        voice = " - Рыбы не разговаривают - (Null Null Null)";
        return voice;
    }

    @Override
    public int getClassAnimail() {
        classAnimail = 5;
        return classAnimail;
    }

    @Override
    public String getKindOfAnimal() {
        kindOfAnimal = "Рыбка:  ";
        return kindOfAnimal;
    }

}

