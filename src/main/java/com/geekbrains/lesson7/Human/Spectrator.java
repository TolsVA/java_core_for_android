package com.geekbrains.lesson7.Human;

public class Spectrator extends Human {
    private int rubles = 100;           //Рубли


    public Spectrator clone(int i) {
        Spectrator spectrator = new Spectrator();
//        name = "Посетитель № " + i;
//        counter = i;
        return spectrator;
    }


    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public int getRubles() {
        return rubles;
    }

    public void setRubles(int rubles) {
        this.rubles = this.rubles - rubles;
    }
}
