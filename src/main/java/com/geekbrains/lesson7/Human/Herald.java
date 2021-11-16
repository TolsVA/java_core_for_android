package com.geekbrains.lesson7.Human;

public class Herald extends Human {
    private int rubles = 0;

    public Herald() {

    }

    public Herald clone(int i) {
        Herald herald = new Herald();
//        name = "Глошатый № " + i;
//        counter = i;
        return herald;
    }

    @Override
    public int getRubles() {
        return rubles;
    }

    @Override
    public void setRubles(int rubles) {
        this.rubles = rubles;
    }

}
