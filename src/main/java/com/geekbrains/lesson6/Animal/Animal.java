package com.geekbrains.lesson6.Animal;

public abstract class Animal {
    protected String kindOfAnimal;
    protected  int counter;
    protected String lainColor = "Чёрный, Белый, Рыжий, Пятнистый";
    protected String name;
    protected String coatColor;
    protected int age;
    protected String voice;
    protected int run;                   // Бег дистанция
    protected double runSpeed;           // Скорость передвижения по суше
    protected double runTime;            // Время забега
    protected int swimming;              // Плавание растояние
    protected double swimmingSpeed;         // Скорость плавания
    protected double swimmingTime;       // Время заплыва
    protected int classAnimail;

    public Animal() {
    }
    public Animal clone() {
        return null;
    }


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoatColor() {
        return lainColor.split(", ")[(int) Math.round(Math.random() * (lainColor.split(", ").length - 1))];
    }
    public void setCoatColor(String coatColor) {
        this.coatColor = coatColor;
    }

    public int getAge() {
        return ((int) Math.round(Math.random()*14) + 1);
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
        return runTime;
    }

    public void setRunTime(double runTime) {
        this.runTime = runTime;
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
        return swimmingTime;
    }

    public void setSwimmingTime(double swimmingTime) {
        this.swimmingTime = swimmingTime;
    }

    public int getClassAnimail() {
        return classAnimail;
    }

    public void setClassAnimail(int classAnimail) {
        this.classAnimail = classAnimail;
    }

}
