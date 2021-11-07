package com.geekbrains.lesson6.Animal;

public class Duck extends Bird{
    private static int z;
    public static String lainChickenName = "Дональд, Кряква, Просто утка-1, Просто утка-2, Просто утка-3, Снежа, Сказка";
    public Duck() {
        flight = 70;
    }

    @Override
    public Duck clone() {
        Duck duck = new Duck();
        duck.name = "Кличка:            - " + lainChickenName.split(", ")[(int) Math.round(Math.random() * (lainChickenName.split(", ").length - 1))];
        z++;
        duck.counter = z;
        return duck;
    }

    @Override
    public double getSwimmingTime(double d, double b) {
        swimmingTime = d / b;
        return swimmingTime;
    }

    @Override
    public int getSwimming() {
        swimming = (((int) (Math.random() * 5)) * 10) + 150;
        return swimming;
    }

    @Override
    public double getSwimmingSpeed() {
        swimmingSpeed = ((int) (Math.random() * 10)) + 30;
        return swimmingSpeed;
    }

    @Override
    public int getRun() {
        run =  ((int) (Math.random() * 9)) + 1;
        return run;
    }

    @Override
    public double getRunSpeed() {
        runSpeed = ((int) (Math.random() * 5)) + 1;;
        return runSpeed;
    }

    @Override
    public double getRunTime(double d, double b) {
        runTime = d/b;
        return runTime;
    }

    @Override
    public String getVoice() {
        voice = " - duck quacks - (Quack! Quack! Quack!)";
        return voice;
    }

    @Override
    public int getClassAnimail() {
        classAnimail = 4;
        return classAnimail;
    }

    @Override
    public String getKindOfAnimal() {
        kindOfAnimal = "Утка:   ";
        return kindOfAnimal;
    }
}
