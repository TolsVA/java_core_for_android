package com.geekbrains.lesson7;

public class Plate {
    private int plateFullness;
    private int numberOfPlates;

    public Plate() {
    }

    public int getPlateFullness() {
        return plateFullness;
    }

    public int setPlateFullness(int i) {
        int x;
        if (getPlateFullness() >= i) {
            this.plateFullness = getPlateFullness() - i;
            x = 0;
            if (this.plateFullness == 0) {
                this.plateFullness = 100;
                numberOfPlates++;
            }
            return x;
        } else {
            i -= getPlateFullness();
            this.plateFullness = 100;
            numberOfPlates++;
            return i;
        }
    }

    public int getNumberOfPlates() {
        return numberOfPlates;
    }

}
