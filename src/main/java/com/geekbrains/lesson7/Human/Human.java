package com.geekbrains.lesson7.Human;


import com.geekbrains.lesson7.Animal.Animal;

public abstract class Human extends Animal {
    protected String position;    // Профессия
    protected String surname;     // Фамилия
    protected String patronymic;  //Отчество
    public  int rubles;           //Рубли

    public Human() {
    }

    public int rubles() {
        return rubles;
    }


    public String getPosition() {
        return position;
    }


    public void setPosition(String position) {
        position = position;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        patronymic = patronymic;
    }

    public int getRubles() {
        return rubles;
    }

    public void setRubles(int rubles) {
        this.rubles = rubles;
    }
}
