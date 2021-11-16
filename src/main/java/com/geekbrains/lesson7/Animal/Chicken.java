package com.geekbrains.lesson7.Animal;

public class Chicken extends Animal {
    private static int z;

    public Chicken() {
        kindOfAnimal = "Курочка:";
        counter = z;
        String lainChickenName = "Ряба, Раиса, Лена, Пеструшка, Пушинка, Снежа, Сказка";
        name = "Кличка:            - " + lainChickenName.split(", ")[(int) Math.round(Math.random() *
                (lainChickenName.split(", ").length - 1))];
        coatColor = lainColor.split(", ")[(int) Math.round(Math.random() * (lainColor.split(", ").length - 1))];
        age = ((int) Math.round(Math.random()*14) + 1);
        run =  ((int) (Math.random() * 9)) + 1;
        runSpeed = ((int) (Math.random() * 5)) + 1;
    }

    @Override
    public Chicken clone() {
        z++;
        return new Chicken();
    }

    @Override
    public String getVoice() {
        voice = " - chicken crows - (Crow! Crow! Crow!)";
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
        classAnimail = 3;
        return classAnimail;
    }
}
