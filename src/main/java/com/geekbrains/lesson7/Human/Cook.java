package com.geekbrains.lesson7.Human;

public  class Cook extends Human {
    private int rubles = 0;
    private int food;    // еда
    private int purse;   //Кошелёк

    public Cook clone(int i) {
        Cook cook = new Cook();
//        name = getName()+ i;
//        counter = i;
        return cook;
    }

//    public String getName() {
//        name = "Повор № ";
//        return name;
//    }

    @Override
    public int getRubles() {
        return rubles;
    }

    @Override
    public void setRubles(int rubles) {
        this.rubles = rubles;
    }
}
