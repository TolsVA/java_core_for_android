package com.geekbrains.lesson7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Homework7 {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Plate plate = new Plate();
        System.out.println("""
                <<<< Введите количество животных которых Вы хотели бы накормить. >>>>""");
        int a = numberOfAthletes();
        Cat cat = new Cat();
        Cat[] cats = new Cat[a];
        int sum = 0;
        for (int i = 0; i < cats.length; i++) {
            cats[i] = cat.clone();
            sum += cats[i].getAppetite();
            System.out.print(cats[i].getName() + "\tАппетит - " + cats[i].getAppetite() + ". ");
            do {
                cats[i].setAppetite(plate.setPlateFullness(cats[i].getAppetite()));
                if (cats[i].getAppetite() == 0) {
                    System.out.println(" Голод удовлетворен.  Общее количество съеденной пищи - " + sum);
                }
            } while (cats[i].getAppetite() != 0);
        }
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Количество тарелок - " + plate.getNumberOfPlates() + " (по 100). Осталось корма в последней тарелке - " +
                ((plate.getNumberOfPlates() * 100) - sum) + ".");
        System.out.println("-------------------------------------------------------------------------------------------");
    }
    public static int numberOfAthletes() {
        int x;
        while (true) {
            try {
                x = in.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели стоку");
                in.next();
            }
        }
        return x;
    }
}
