package com.geekbrains.lesson6.Animal;

public class Fish extends Animal{
    private static int z = 1;
    private static final String lainFishColor = "Чёрный, Белый, Полосатый, Пятнистый, Серебристый";
    private static final String lainFishName = "Адольф, Боря, Вини, Гарик, Джин, Ерик, Конфуций, Лун тик, Пират, Тики-тики, Уильям, Усач";

    public Fish() {
        setKindOfAnimal("Рыбка:  ");
        setCounter(z);
        setName("Кличка:            - " + lainFishName.split(", ")[(int) Math.round(Math.random() *
                (lainFishName.split(", ").length - 1))]);
        setVoice(" - Рыбы не разговаривают - (Null Null Null)");
        setCoatColor(lainFishColor.split(", ")[(int) Math.round(Math.random() *
                (lainFishColor.split(", ").length - 1))]);
        setAge(((int) Math.round(Math.random()*14) + 1));
        setRun(0);
        setRunSpeed(0);
        setSwimming((((int) (Math.random() * 10)) * 10) + 400);
        setSwimmingSpeed(((int) (Math.random() * 10)) + 150);
        setClassAnimail(5);
    }

    @Override
    public Fish clone() {
        Fish fish = new Fish();
        z++;
        return fish;
    }
}
