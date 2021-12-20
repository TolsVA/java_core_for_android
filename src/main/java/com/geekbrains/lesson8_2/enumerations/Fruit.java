package com.geekbrains.lesson8_2.enumerations;

public enum Fruit {
    ORANGE("Апельсин", 3, 6),
    APPLE("Яблоко", 3, 7),
    BANANA("Банан", 2, 8),
    CHERRY("Вишня", 1, 9);

    private String russianTitle;
    private int weight; // вес
    private int volume; // объём

    public String getRussianTitle() {
        return russianTitle;
    }

    public int getWeight() {
        return weight;
    }

    public int getVolume() {
        return volume;
    }

    Fruit(String russianTitle, int weight, int volume) {
        this.russianTitle = russianTitle;
        this.weight = weight;
        this.volume = volume;
    }
}
