package com.geekbrains.lesson6;

import com.geekbrains.lesson6.Animal.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Homework6 {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws CloneNotSupportedException {
        start();
    }

    private static void start() throws CloneNotSupportedException {
        int zDog = 0;
        int zCat = 0;
        int zChicken = 0;
        int zDuck = 0;
        int zFish = 0;
        int s;
        Cat cat = new Cat();
        Dog dog = new Dog();
        Chicken chicken = new Chicken();
        Duck duck = new Duck();
        Fish fish = new Fish();
        Animal[] animals = new Animal[]{cat, dog, chicken, duck, fish};
        System.out.println("""
                Вы попали на виртуальную ферму прямо в разгар соревнований между домашними животными.
                Вам предоставляется исключительное право подобрать спортсменов.
                        <<<< Введите количество животных для старта. >>>>""");
        int a = numberOfAthletes2();
        Animal[] animals1 = new Animal[a];
        for (int i = 0; i < animals1.length; i++) {
            s = (int) Math.round(Math.random() * (animals.length - 1));
            animals1[i] = animals[s].clone();
            if (animals[s].equals(chicken)) {zChicken++;}
            if (animals[s].equals(cat)) {zCat++;}
            if (animals[s].equals(dog)) {zDog++;}
            if (animals[s].equals(duck)) {zDuck++;}
            if (animals[s].equals(fish)) {zFish++;}
            print(animals1[i], i + 1);
        }
        print(a, zDog, zCat, zChicken, zDuck, zFish);
        chooseACompetition(animals1, a, zDog, zCat, zChicken, zDuck, zFish);
    }

    private static void chooseACompetition(Animal[] animals1, int a, int zDog, int zCat, int zChicken, int zDuck, int zFish) throws CloneNotSupportedException {
        System.out.println("""
                Выбери вид соревнований:      (( Бег - 1. <---> Плавание - 2. ))
                                                         И Л И
                (( Создать новый список спортсменов - 3.  <--->   Закончить соревнования - 4. ))""");
        int b = numberOfAthletes(1, 4);
        if (b == 1) {
            startRun(animals1, a, zDog, zCat, zChicken, zDuck, zFish);
        } else if (b == 2) {
            startSwimming(animals1, a, zDog, zCat, zChicken, zDuck, zFish);
        } else if (b == 3) {
            start();
        } else if (b == 4) {
            gameOver();
        }
    }

    private static void gameOver() {
        System.out.println("GAME OVER     GAME OVER     GAME OVER     GAME OVER     GAME OVER");
    }

    private static void startSwimming(Animal[] animals1, int a, int zDog, int zCat, int zChicken, int zDuck, int zFish) throws CloneNotSupportedException {
        int nDog = 0;
        int nCat = 0;
        int nChicken = 0;
        int nDuck = 0;
        int nFish = 0;
        int b = a;
        System.out.println("<<<<< Введите расстояние. >>>>> PS: Рекомендуется выбрать расстояние в диапазоне от 1 до 500 метров.");
        double d = numberOfAthletes(1, 500);
        for (int i = 0; i < animals1.length; i++) {
            if (animals1[i].getSwimming() >= d) {
                if (animals1[i].getClassAnimail() == 1) {nDog++;}
                if (animals1[i].getClassAnimail() == 2) {nCat++;}
                if (animals1[i].getClassAnimail() == 3) {nChicken++;}
                if (animals1[i].getClassAnimail() == 4) {nDuck++;}
                if (animals1[i].getClassAnimail() == 5) {nFish++;}
                double r = animals1[i].getSwimmingTime(d, animals1[i].getSwimmingSpeed());
                print2(animals1[i], d, r, i + 1);
            } else {
                b--;
            }
        }
        print1(b, nDog, nCat, nChicken, nDuck, nFish, animals1.length, zDog, zCat, zChicken, zDuck, zFish);
        Animal[] animals2 = new Animal[b];
        int y = 0;
        for (int i = 0; i < animals1.length -1; i++) {
            if (animals1[i].getSwimming() >= d ) {
                animals2[y] = animals1[i];
                y++;
            }
        }
        double m = 100000;
        int p = -1;
        for (int i = 0; i < animals2.length - 1; i++) {
            if (animals2[i].getSwimmingTime(d, animals2[i].getSwimmingSpeed()) < m &&
                    animals2[i].getSwimmingTime(d, animals2[i].getSwimmingSpeed()) > 0) {
                m = animals2[i].getSwimmingTime(d, animals2[i].getSwimmingSpeed());
                p = i;
            }
        }
        if (p != -1) {
            System.out.println("---------------------------------------------------------------------------" +
                    "--------------------------------");
            System.out.printf("""
                    Победитель гонки   - %s
                    %s - %s лет.
                    <<<<<< Проплыл дистанцию с лучшим временем - %.2f минут и занял 1 место в заплыве на - %s метров! >>>>>>""",
                    animals2[p].getKindOfAnimal(), animals2[p].getName(), animals2[p].getAge(), m, d);
            System.out.println("\n---------------------------------------------" +
                    "--------------------------------------------------------------");
        } else {
            System.out.println("Слишком большое расстояние для ваших спортсменов ни кто не дошёл до финиша.");
        }

        chooseACompetition(animals1, a, zDog, zCat, zChicken, zDuck, zFish);

    }
    private static void startRun(Animal[] animals1, int a, int zDog, int zCat, int zChicken, int zDuck, int zFish) throws CloneNotSupportedException {
        int nDog = 0;
        int nCat = 0;
        int nChicken = 0;
        int nDuck = 0;
        int nFish = 0;
        int b = a;
        System.out.println("<<<<< Введите расстояние. >>>>> PS: Рекомендуется выбрать расстояние в диапазоне от 1 до 500 метров.");
        double d = numberOfAthletes(1, 500);
        for (int i = 0; i < animals1.length; i++) {
            if (animals1[i].getRun() >= d) {
                if (animals1[i].getClassAnimail() == 1) {nDog++;}
                if (animals1[i].getClassAnimail() == 2) {nCat++;}
                if (animals1[i].getClassAnimail() == 3) {nChicken++;}
                if (animals1[i].getClassAnimail() == 4) {nDuck++;}
                if (animals1[i].getClassAnimail() == 5) {nFish++;}
                double r = animals1[i].getRunTime(d, animals1[i].getRunSpeed());
                print1(animals1[i], d, r, i + 1);
            } else {
                b--;
            }
        }
        print1(b, nDog, nCat, nChicken, nDuck, nFish, animals1.length, zDog, zCat, zChicken, zDuck, zFish);
        Animal[] animals2 = new Animal[b];
        int y = 0;
        for (Animal animal : animals1) {
            if (animal.getRun() >= d) {
                animals2[y] = animal;
                y++;
            }
        }
        double m = 100000;
        int p = -1;
        for (int i = 0; i < animals2.length; i++) {
            if (animals2[i].getRunTime(d, animals2[i].getRunSpeed()) < m &&
                    animals2[i].getRunTime(d, animals2[i].getRunSpeed()) > 0) {
                m = animals2[i].getRunTime(d, animals2[i].getRunSpeed());
                p = i;
            }
        }
        if (p != -1) {
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.printf("""
                    Победитель гонки   - %s
                    %s - %s лет.
                    <<<<<< Пробежал дистанцию с лучшим временем - %.2f минут и занял 1 место в забеге на - %s метров! >>>>>>""",
                    animals2[p].getKindOfAnimal(), animals2[p].getName(), animals2[p].getAge(), m, d);
            System.out.println("\n-----------------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("Слишком большое расстояние для ваших спортсменов ни кто не дошёл до финиша.");
        }
        chooseACompetition(animals1, a, zDog, zCat, zChicken, zDuck, zFish);
    }


    private static void print(int a, int i, int j, int x, int y, int z) {
        System.out.printf("""
                        Всего спортсменов - %s
                        Собак - %s
                        Котов - %s
                        Куриц - %s
                        Уток  - %s
                        Рыб   - %s
                        """,
                a, i, j, x, y, z);
    }

    private static void print1(int a, int i, int j, int x, int y, int z, int aa, int ii, int jj, int xx, int yy, int zz) {
        System.out.println();
        System.out.printf("""
                        ___________________________________
                        | Дошли до       |      Сошло с    |
                        | финиша - %s     |  дистанции - %s |
                        | ---------------|-----------------|
                        | Собак    - %s   |     - %s        |
                        | Котов    - %s   |     - %s        |
                        | Куриц    - %s   |     - %s        |
                        | Уток     - %s   |     - %s        |
                        | Рыб      - %s   |     - %s        |
                        |________________|_________________|
                        """,
                a, (aa - a), i, (ii - i), j, (jj - j), x, (xx - x), y, (yy -y), z, (zz - z));
    }



    private static void print(Animal animals, int i) {
        System.out.printf("""
                        %s           - %04d   В забеге  - %04d
                        %s%s
                        Цвет:              - %s
                        Возраст:           - %s\t\tлет.
                        Мах.Дистанция:     - %s\tметров. (Мах. Дистанция для спортсмена)
                        Плавание:          - %s\t\tметров.
                        """,
                animals.getKindOfAnimal(), animals.getCounter(), i, animals.getName(), animals.getVoice(),
                animals.getCoatColor(),animals.getAge(), animals.getRun(), animals.getSwimming());
        System.out.println("------------------------------------------------------------------------");
    }

    private static void print1(Animal animals,double d, double r, int i) {
        System.out.printf("""
                        %s           - %04d   В забеге  - %04d
                        %s%s
                        Цвет:              - %s
                        Возраст:           - %s\t\tлет.
                        Мах.Дистанция:     - %s\tметров.  (Мах. Дистанция для спортсмена)
                        Скорость:          - %s\tметров/минуту.
                        Дист. забега:      - %s\tметров.
                        Время забега:      - %.2f\tминут.
                        """,
                animals.getKindOfAnimal(), animals.getCounter(), i, animals.getName(), animals.getVoice(),
                animals.getCoatColor(),animals.getAge(), animals.getRun(), animals.getRunSpeed(), d, r);
        System.out.println("------------------------------------------------------------------------");
    }

    private static void print2(Animal animals,double d, double r, int i) {
        System.out.printf("""
                        %s           - %04d   В забеге  - %04d
                        %s%s
                        Цвет:              - %s
                        Возраст:           - %s\t\tлет.
                        Мах.Дистанция:     - %s\tметров.  (Мах. Дистанция для спортсмена)
                        Скорость:          - %s\tметров/минуту.
                        Дист. заплыв:      - %s\tметров.
                        Время заплыв:      - %.2f\tминут.
                        """,
                animals.getKindOfAnimal(), animals.getCounter(), i, animals.getName(), animals.getVoice(),
                animals.getCoatColor(),animals.getAge(), animals.getSwimming(), animals.getSwimmingSpeed(), d, r);
        System.out.println("------------------------------------------------------------------------");
    }
    public static int numberOfAthletes2() {
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

    public static int numberOfAthletes(int i, int j) {
        int x;
        while (true) {
            try {
                x = getNumberFromScanner("Вы ввели символы не влияющие на ход " +
                        "выполнения программы.", i, j);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели стоку");
                in.next();
            }
        }
        return x;
    }

    public static int getNumberFromScanner(String message, int min, int max) {
        int x;
        do {
            x = in.nextInt();
            if (x >= min && x <= max ) {
                return x;
            }
            System.out.println(message);
        } while (true);
    }
}
