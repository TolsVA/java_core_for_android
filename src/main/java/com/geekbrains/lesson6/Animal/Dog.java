package com.geekbrains.lesson6.Animal;

public class Dog extends Animal {
    private static int z;
    private static String lainDogName = "Гром, Бакс, Чак, Гектор, Тузик, Бобик, Зевс, Бим, Валет, Дружок";
    protected int endurance;    // Выносливость

    public Dog() {

    }

    @Override
    public double getSwimmingTime(double d, double b) {
        swimmingTime = d / b;
        return swimmingTime;
    }

    @Override
    public int getSwimming() {
        swimming = ((int) (Math.random() * 10)) + 10;
        return swimming;
    }
    @Override
    public double getSwimmingSpeed() {
        swimmingSpeed = (int) (Math.random() * 5) + 1;
        return swimmingSpeed;
    }

    @Override
    public int getRun() {
        run =  (((int) (Math.random() * 10)) * 10) + 400;
        return run;
    }

    @Override
    public double getRunSpeed() {
        runSpeed = ((int) (Math.random() * 10)) + 50;
        return runSpeed;
    }

    @Override
    public double getRunTime(double d, double b) {
        runTime = d/b;
        return runTime;
    }

    @Override
    public Animal clone() {
        Dog dog = new Dog();
        dog.name = "Кличка:            - " + lainDogName.split(", ")[(int) Math.round(Math.random() * (lainDogName.split(", ").length - 1))];
        z++;
        dog.counter = z;
        return dog;
    }

    @Override
    public String getVoice() {
        voice = " - the dog barks - (Gaw! Gaw! Gaw!)";
        return voice;
    }

    @Override
    public int getClassAnimail() {
        classAnimail = 1;
        return classAnimail;
    }

    @Override
    public String getKindOfAnimal() {
        kindOfAnimal = "Собака: ";
        return kindOfAnimal;
    }

}
