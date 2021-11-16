package com.geekbrains.lesson7.Animal;

public class Fish extends Animal {
    private static int z;

    public Fish() {
        kindOfAnimal = "Рыбка:  ";
        counter = z;
        String lainDogName = "Адольф, Боря, Вини, Гарик, Джин, Ерик, Конфуций, Лун-тик, Пират, Тики-тики, Уильям, Усач";
        name = "Кличка:            - " + lainDogName.split(", ")[(int) Math.round(Math.random() *
                (lainDogName.split(", ").length - 1))];
        coatColor = lainColor.split(", ")[(int) Math.round(Math.random() * (lainColor.split(", ").length - 1))];
        age = ((int) Math.round(Math.random()*14) + 1);
        swimming = (((int) (Math.random() * 10)) * 10) + 400;
        swimmingSpeed = ((int) (Math.random() * 10)) + 150;

    }

    @Override
    public Fish clone() {
        z++;
        return new Fish();
    }

    @Override
    public String getVoice() {
        voice = " - Рыбы не разговаривают - (Null Null Null)";
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
        classAnimail = 5;
        return classAnimail;
    }
}

