package com.geekbrains.lesson7.Animal;

public class Duck extends Animal {
    private static int z;

    public Duck() {
        kindOfAnimal = "Утка:   ";
        counter = z;
        String lainChickenName = "Дональд, Кряква, Просто утка-1, Просто утка-2, Просто утка-3, Снежа, Сказка";
        name = "Кличка:            - " + lainChickenName.split(", ")[(int) Math.round(Math.random() *
                (lainChickenName.split(", ").length - 1))];
        coatColor = lainColor.split(", ")[(int) Math.round(Math.random() * (lainColor.split(", ").length - 1))];
        age = ((int) Math.round(Math.random()*14) + 1);
        run =  ((int) (Math.random() * 9)) + 1;
        runSpeed = ((int) (Math.random() * 5)) + 1;
        swimming = (((int) (Math.random() * 5)) * 10) + 150;
        swimmingSpeed = ((int) (Math.random() * 10)) + 30;
    }

    @Override
    public Duck clone() {
        z++;
        return new Duck();
    }

    @Override
    public String getVoice() {
        voice = " - duck quacks - (Quack! Quack! Quack!)";
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
        classAnimail = 4;
        return classAnimail;
    }
}
