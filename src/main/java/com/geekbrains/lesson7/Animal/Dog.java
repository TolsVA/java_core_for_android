package com.geekbrains.lesson7.Animal;

public class Dog extends Animal {
    private static int z;

    public Dog() {
        kindOfAnimal = "Собака: ";
        counter = z;
        String lainDogName = "Гром, Бакс, Чак, Гектор, Тузик, Бобик, Зевс, Бим, Валет, Дружок";
        name = "Кличка:            - " + lainDogName.split(", ")[(int) Math.round(Math.random() *
                (lainDogName.split(", ").length - 1))];
        coatColor = lainColor.split(", ")[(int) Math.round(Math.random() * (lainColor.split(", ").length - 1))];
        age = ((int) Math.round(Math.random()*14) + 1);
        run =  (((int) (Math.random() * 10)) * 10) + 400;
        runSpeed = ((int) (Math.random() * 10)) + 50;
        swimming = ((int) (Math.random() * 10)) + 10;
        swimmingSpeed = (int) (Math.random() * 5) + 1;

    }

    @Override
    public Dog clone() {
        z++;
        return new Dog();
    }

    @Override
    public String getVoice() {
        voice = " - the dog barks - (Gaw! Gaw! Gaw!)";
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
        classAnimail = 1;
        return classAnimail;
    }
}
