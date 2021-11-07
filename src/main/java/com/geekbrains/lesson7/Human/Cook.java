package com.geekbrains.lesson7.Human;

public  class Cook extends Human {
    private int rubles = 0;
    private int food;    // еда
    private int purse;   //Кошелёк

    public Cook clone(int i) {
        Cook cook = new Cook();
        cook.name = "Повор № " + i;
        cook.counter = i;
        return cook;
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
