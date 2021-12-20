package com.geekbrains.lesson8_2.enumerations;

public class TestClass1 {
    public static void main(String[] args) {

//        Fruit fruit = Fruit.APPLE; System.out.println(fruit);
//
//        if (fruit == Fruit.APPLE) {
//            System.out.println("fruit действительно является яблоком"); }
//        switch (fruit ) { case APPLE:
//            System.out.println("fruit - яблоко");
//            break; case ORANGE:
//            System.out.println("fruit - апельсин");
//            break; case CHERRY:
//            System.out.println("fruit - вишня");
//            break; }
        System.out.println("Все элементы перечисления:");
        for(Fruit fruit : Fruit.values()) {
            System.out.println(fruit); }

        System.out.println("Поиск по названию: " + Fruit.valueOf("BANANA"));


        for(Fruit fruit : Fruit.values()) {
            System.out.printf("Средний вес фрукта %s составляет: %d грамм. объём: %d диц.куб\n",
                    fruit.getRussianTitle(), fruit.getWeight() * 100, fruit.getVolume()*100);
        }
    }
}
