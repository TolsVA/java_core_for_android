package com.geekbrains.lesson6.Animal;

public class Chicken extends Animal{
    private static int z = 1;
    private static final String lainChickenColor = "Чёрный, Белый, Рыжий, Пятнистый";
    private static final String lainChickenName = "Ряба, Раиса, Лена, Пеструшка, Пушинка, Снежа, Сказка";

    public Chicken() {
        setKindOfAnimal("Курочка:");
        setCounter(z);
        setName("Кличка:            - " + lainChickenName.split(", ")[(int) Math.round(Math.random() *
                (lainChickenName.split(", ").length - 1))]);
        setVoice(" - chicken crows - (Grow! Grow! Grow!)");
        setCoatColor(lainChickenColor.split(", ")[(int) Math.round(Math.random() *
                (lainChickenColor.split(", ").length - 1))]);
        setAge(((int) Math.round(Math.random()*14) + 1));
        setRun(((int) (Math.random() * 9)) + 1);
        setRunSpeed(((int) (Math.random() * 5)) + 1);
        setSwimming(0);
        setSwimmingSpeed(0);
        setClassAnimail(3);
    }

    @Override
    public Chicken clone() {
        Chicken chicken = new Chicken();
        z++;
        return chicken;
    }
}
