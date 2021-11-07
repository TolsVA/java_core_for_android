package com.geekbrains.lesson7.Animal;

public class Chicken extends Bird{
    private static int z;
    public static String lainChickenName = "Ряба, Раиса, Лена, Пеструшка, Пушинка, Снежа, Сказка";
    public Chicken() {
        flight = 100;
    }

    @Override
    public int getRun() {
        run =  ((int) (Math.random() * 9)) + 1;
        return run;
    }

    @Override
    public double getRunSpeed() {
        runSpeed = ((int) (Math.random() * 5)) + 1;
        return runSpeed;
    }

    @Override
    public double getRunTime(double d, double b) {
        runTime = d/b;
        return runTime;
    }

    @Override
    public Chicken clone() {
        Chicken chicken = new Chicken();
        chicken.name = "Кличка:            - " + lainChickenName.split(", ")[(int) Math.round(Math.random() * (lainChickenName.split(", ").length - 1))];
        z++;
        chicken.counter = z;
        return chicken;
    }


    @Override
    public String getVoice() {
        voice = " - chicken crows - (Сrow! Сrow! Сrow!)";
        return voice;
    }

    @Override
    public int getClassAnimail() {
        classAnimail = 3;
        return classAnimail;
    }

    @Override
    public String getKindOfAnimal() {
        kindOfAnimal = "Курочка:";
        return kindOfAnimal;
    }
}
