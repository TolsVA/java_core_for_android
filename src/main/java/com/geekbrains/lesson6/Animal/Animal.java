package com.geekbrains.lesson6.Animal;

public abstract class Animal {
    private String kindOfAnimal;
    private int counter;
    private String name;
    private String voice;
    private String coatColor;
    private int age;
    private int run;                   // Бег дистанция
    private double runSpeed;           // Скорость передвижения по суше
    private int swimming;              // Плавание расстояние
    private double swimmingSpeed;      // Скорость плавания
    private int classAnimail;

    public Animal() {
    }

    public Animal clone() {
        return null;}

    public String getKindOfAnimal() {
        return kindOfAnimal;
    }

    public void setKindOfAnimal(String kindOfAnimal) {
        this.kindOfAnimal = kindOfAnimal;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getCoatColor() {
        return coatColor;
    }

    public void setCoatColor(String coatColor) {
        this.coatColor = coatColor;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public double getRunSpeed() {
        return runSpeed;
    }

    public void setRunSpeed(double runSpeed) {
        this.runSpeed = runSpeed;
    }

    public double getRunTime(double d, double b) {
        return d / b;
    }

    public int getSwimming() {
        return swimming;
    }

    public void setSwimming(int swimming) {
        this.swimming = swimming;
    }

    public double getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(double swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    public double getSwimmingTime(double d, double b) {
        return d / b;
    }

    public int getClassAnimail() {
        return classAnimail;
    }

    public void setClassAnimail(int classAnimail) {
        this.classAnimail = classAnimail;
    }
}
