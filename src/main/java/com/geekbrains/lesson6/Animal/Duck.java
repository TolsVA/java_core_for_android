package com.geekbrains.lesson6.Animal;

public class Duck extends Animal{
    private static int z = 1;
    private static final String lainDuckColor = "Чёрный, Белый, Рыжий, Пятнистый";
    private static final String lainChickenName = "Дональд, Кряква, Просто утка-1, Просто утка-2, Просто утка-3, Снежа, Сказка";

    public Duck() {
        setKindOfAnimal("Утка:   ");
        setCounter(z);
        setName("Кличка:            - " + lainChickenName.split(", ")[(int) Math.round(Math.random() *
                (lainChickenName.split(", ").length - 1))]);
        setVoice(" - duck quacks - (Quack! Quack! Quack!)");
        setCoatColor(lainDuckColor.split(", ")[(int) Math.round(Math.random() *
                (lainDuckColor.split(", ").length - 1))]);
        setAge(((int) Math.round(Math.random()*14) + 1));
        setRun(((int) (Math.random() * 9)) + 1);
        setRunSpeed(((int) (Math.random() * 5)) + 1);
        setSwimming((((int) (Math.random() * 5)) * 10) + 150);
        setSwimmingSpeed((int) (Math.random() * 5) + 1);
        setClassAnimail(4);
    }

    @Override
    public Duck clone() {
        Duck duck = new Duck();
        z++;
        return duck;
    }
}
