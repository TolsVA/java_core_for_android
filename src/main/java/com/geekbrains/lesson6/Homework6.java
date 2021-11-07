package com.geekbrains.lesson6;

import com.geekbrains.lesson6.Animal.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Homework6 {
    public static Scanner in = new Scanner(System.in);
    public static Scanner se = new Scanner(System.in);
    public static void main(String[] args) throws CloneNotSupportedException {
        start();
    }

    private static void start() {
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
        System.out.println("Вы попали на виртуальную ферму прямо в разгар соревнований между домашними животными.\nВам предоставляется " +
                "исключительное право подобрать спортсменов.\n        <<<< Введите количество животных для старта. >>>>");
        int a = numberOfAthletes2();
        Animal[] animals1 = new Animal[a];
        String[][] arr = new String[a][9];
        for (int i = 0; i < animals1.length; i++) {
            s = (int) Math.round(Math.random() * (animals.length - 1));
            animals1[i] = animals[s].clone();
            if (animals[s].equals(chicken)) {zChicken++;}
            if (animals[s].equals(cat)) {zCat++;}
            if (animals[s].equals(dog)) {zDog++;}
            if (animals[s].equals(duck)) {zDuck++;}
            if (animals[s].equals(fish)) {zFish++;}
            arr[i][0] = String.valueOf(animals1[i].getCounter());
            arr[i][1] = String.valueOf(i + 1);
            arr[i][2] = animals1[i].getName();
            arr[i][3] = animals1[i].getCoatColor();
            arr[i][4] = String.valueOf(animals1[i].getAge());
            arr[i][5] = String.valueOf(animals1[i].getRun());
            arr[i][6] = String.valueOf(animals1[i].getRunSpeed());
            arr[i][7] = String.valueOf(animals1[i].getSwimming());
            arr[i][8] = String.valueOf(animals1[i].getSwimmingSpeed());
            String[] arr1 = new String[]{arr[i][0], arr[i][1], arr[i][2], arr[i][3], arr[i][4], arr[i][5], arr[i][6], arr[i][7], arr[i][8]};
            print(animals1[i], arr1);
        }
        print(a, zDog, zCat, zChicken, zDuck, zFish);
        chooseACompetition(animals1, a, zDog, zCat, zChicken, zDuck, zFish, arr);
    }

    private static void chooseACompetition(Animal[] animals1, int a, int zDog, int zCat, int zChicken, int zDuck, int zFish, String[][] arr) {
        System.out.println("Выбери вид соревнований:      (( Бег - 1 <---> Плавание - 2. )) " +
                "\n                                         И Л И\n" +
                "(( Создать новый список спортсменов - 3  <--->   Закончить соревнования - 4. ))");
        int b = numberOfAthletes();
        if (b == 1) {
            startRun(animals1, a, zDog, zCat, zChicken, zDuck, zFish, arr);
        } else if (b == 2) {
            startSwimming(animals1, a, zDog, zCat, zChicken, zDuck, zFish, arr);
        } else if (b == 3) {
            start();
        } else if (b == 4) {
            gameOver();
        }
    }

    private static void gameOver() {
        System.out.println("GAME OVER     GAME OVER     GAME OVER     GAME OVER     GAME OVER");
    }

    private static void startSwimming(Animal[] animals1, int a, int zDog, int zCat, int zChicken, int zDuck, int zFish, String[][] arr) {
        int nDog = 0;
        int nCat = 0;
        int nChicken = 0;
        int nDuck = 0;
        int nFish = 0;
        int b = a;
        System.out.println("<<<<< Введите растояние. >>>>> PS: Рекомендуется выбрать растояние в диапазоне от 1 до 500 метров.");
        double d = numberOfAthletes1();
        for (int i = 0; i < animals1.length; i++) {
            if (Integer.parseInt(String.valueOf(arr[i][7])) >= d) {
                if (animals1[i].getClassAnimail() == 1) {nDog++;}
                if (animals1[i].getClassAnimail() == 2) {nCat++;}
                if (animals1[i].getClassAnimail() == 3) {nChicken++;}
                if (animals1[i].getClassAnimail() == 4) {nDuck++;}
                if (animals1[i].getClassAnimail() == 5) {nFish++;}
                String[] arr1 = new String[]{arr[i][0], arr[i][1], arr[i][2], arr[i][3], arr[i][4], arr[i][5], arr[i][6], arr[i][7], arr[i][8]};
                double r = animals1[i].getSwimmingTime(d, Double.parseDouble(String.valueOf(arr[i][8])));
                print2(animals1[i], d, r, arr1);
            } else {
                b--;
            }
        }
        print1(b, nDog, nCat, nChicken, nDuck, nFish, animals1.length, zDog, zCat, zChicken, zDuck, zFish);
        Animal[] animals2 = new Animal[b];
        String[][] arr2 = new String[b][9];
        int y = 0;
        for (int i = 0; i < animals1.length -1; i++) {
            if (Double.parseDouble(String.valueOf(arr[i][7])) >= d ) {
                animals2[y] = animals1[i];
                for (int j = 0; j < arr2[y].length; j++) {
                    arr2[y][j] = arr[i][j];
                }
                y++;
            }
        }
        double m = 100000;
        int p = -1;
        for (int i = 0; i < animals2.length - 1; i++) {
            if (animals2[i].getSwimmingTime(d, Double.parseDouble(String.valueOf(arr2[i][8]))) < m &&
                    animals2[i].getSwimmingTime(d, Double.parseDouble(String.valueOf(arr2[i][8]))) > 0) {
                m = animals2[i].getSwimmingTime(d, Double.parseDouble(String.valueOf(arr2[i][8])));
                p = i;
            }
        }
        if (p != -1) {
            System.out.println("---------------------------------------------------------------------------" +
                    "--------------------------------");
            System.out.printf("Победитель гонки   - %s\n%s - %s лет.\n<<<<<< Проплыл дистанцию с лучшим " +
                    "временем - %.2f минут и занял 1 место " +
                    "в заплыве на - %s метров! >>>>>>", animals2[p].getKindOfAnimal(), arr2[p][2], arr2[p][4], m, d);
            System.out.println("\n---------------------------------------------" +
                    "--------------------------------------------------------------");
        } else {
            System.out.println("Слишком большое растояние для ваших спортсменов ни кто не дошол до финиша.");
        }

        chooseACompetition(animals1, a, zDog, zCat, zChicken, zDuck, zFish, arr);

    }
    private static void startRun(Animal[] animals1, int a, int zDog, int zCat, int zChicken, int zDuck, int zFish, String[][] arr) {
        int nDog = 0;
        int nCat = 0;
        int nChicken = 0;
        int nDuck = 0;
        int nFish = 0;
        int b = a;
        System.out.println("<<<<< Введите растояние. >>>>> PS: Рекомендуется выбрать растояние в диапазоне от 1 до 500 метров.");
        double d = numberOfAthletes1();
        for (int i = 0; i < animals1.length; i++) {
            if (Double.parseDouble(String.valueOf(arr[i][5])) >= d) {
                if (animals1[i].getClassAnimail() == 1) {nDog++;}
                if (animals1[i].getClassAnimail() == 2) {nCat++;}
                if (animals1[i].getClassAnimail() == 3) {nChicken++;}
                if (animals1[i].getClassAnimail() == 4) {nDuck++;}
                if (animals1[i].getClassAnimail() == 5) {nFish++;}
                String[] arr1 = new String[]{arr[i][0], arr[i][1], arr[i][2], arr[i][3], arr[i][4], arr[i][5], arr[i][6], arr[i][7], arr[i][8]};
                double r = animals1[i].getRunTime(d, Double.parseDouble(String.valueOf(arr[i][6])));
                print1(animals1[i], d, r, arr1);
            } else {
                b--;
            }
        }
        print1(b, nDog, nCat, nChicken, nDuck, nFish, animals1.length, zDog, zCat, zChicken, zDuck, zFish);
        Animal[] animals2 = new Animal[b];
        String[][] arr2 = new String[b][9];
        int y = 0;
        for (int i = 0; i < animals1.length; i++) {
            if (Double.parseDouble(String.valueOf(arr[i][5])) >= d ) {
                animals2[y] = animals1[i];
                for (int j = 0; j < arr2[y].length; j++) {
                    arr2[y][j] = arr[i][j];
                }
                y++;
            }
        }
        double m = 100000;
        int p = -1;
        for (int i = 0; i < animals2.length; i++) {
            if (animals2[i].getRunTime(d, Double.parseDouble(String.valueOf(arr2[i][6]))) < m &&
                    animals2[i].getRunTime(d, Double.parseDouble(String.valueOf(arr2[i][6]))) > 0) {
                m = animals2[i].getRunTime(d, Double.parseDouble(String.valueOf(arr2[i][6])));
                p = i;
            }
        }
        if (p != -1) {
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.printf("Победитель гонки   - %s\n%s - %s лет.\n<<<<<< Пробежал дистанцию с лучшим временем - %.2f минут и занял 1 место " +
                    "в забеге на - %s метров! >>>>>>", animals2[p].getKindOfAnimal(), arr2[p][2], arr2[p][4], m, d);
            System.out.println("\n-----------------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("Слишком большое растояние для ваших спортсменов ни кто не дошол до финиша.");
        }
        chooseACompetition(animals1, a, zDog, zCat, zChicken, zDuck, zFish, arr);
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
        System.out.printf("""
                        \n___________________________________
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



    private static void print(Animal animals, String[] arr1) {
        System.out.printf("""
                        %s           - %04d   В забеге  - %04d
                        %s%s
                        Цвет:              - %s
                        Возраст:           - %s\t\tлет.
                        Мах.Дистанция:     - %s\tметров. (Мах. Дистанция для спортсмена)
                        Плавание:          - %s\t\tметров.
                        """,
                animals.getKindOfAnimal(), Integer.parseInt(String.valueOf(arr1[0])), Integer.parseInt(String.valueOf(arr1[1])), arr1[2], animals.getVoice(),
                arr1[3], Integer.parseInt(String.valueOf(arr1[4])), Integer.parseInt(String.valueOf(arr1[5])), Integer.parseInt(String.valueOf(arr1[7])));
        System.out.println("------------------------------------------------------------------------");
    }

    private static void print1(Animal animals,double d, double r, String[] arr1) {
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
                animals.getKindOfAnimal(), Integer.parseInt(String.valueOf(arr1[0])), Integer.parseInt(String.valueOf(arr1[1])), arr1[2], animals.getVoice(),
                arr1[3], Integer.parseInt(String.valueOf(arr1[4])), Integer.parseInt(String.valueOf(arr1[5])),
                Double.parseDouble(String.valueOf(arr1[6])), d, r);
        System.out.println("------------------------------------------------------------------------");
    }

    private static void print2(Animal animals,double d, double r, String[] arr1) {
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
                animals.getKindOfAnimal(), Integer.parseInt(String.valueOf(arr1[0])), Integer.parseInt(String.valueOf(arr1[1])), arr1[2], animals.getVoice(),
                arr1[3], Integer.parseInt(String.valueOf(arr1[4])), Integer.parseInt(String.valueOf(arr1[7])),
                Double.parseDouble(String.valueOf(arr1[8])), d, r);
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



    public static int numberOfAthletes1 () {
        int x;
        while (true) {
            try {
                x = getNumberFromScanner("Вы ввели символы не влияюшие на ход " +
                        "выполнения программы.", 1, 500);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели стоку");
                in.next();
            }
        }
        return x;
    }

    public static int numberOfAthletes() {
        int x;
        while (true) {
            try {
                x = getNumberFromScanner("Вы ввели символы не влияюшие на ход " +
                        "выполнения программы.", 1, 4);
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
        } while (x < min || x > max);
        return x;
    }
}
