package com.geekbrains.lesson7;

public class Cat {
    private String name;
    private int appetite;
    Cat(){
        String lainCatName = "Вася: , Вирус:, Ватсон:, Барсик:, Пушок:, Хася: , Проша:, Кузя: , Стёпа:, Хусейн:, Мурзик:";
        setName("Кот - " + lainCatName.split(", ")[(int) Math.round(Math.random() *
                (lainCatName.split(", ").length - 1))]);
        setAppetite((((int) (Math.random() * 4)) * 10) + 10);
    }

    public String getName() {
        return name;
    }

    public Cat clone() {
        return new Cat();
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }
}
