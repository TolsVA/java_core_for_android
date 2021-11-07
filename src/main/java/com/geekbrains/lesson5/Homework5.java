package com.geekbrains.lesson5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Homework5 {
    public static Scanner in = new Scanner(System.in);
    public static Scanner se = new Scanner(System.in);
    public static String lainSurname = "Тягай, Александров, Яковенко, Яковлев, Ершов, Федункив, Желиба, Белоусов, Захаров, Селезнёв, " +
            "Кононов, Кириленко, Горбунов, Кличко, Максимов, Повалий, Князев, Симонов, Орлов, Семёнов, Григорьев, Быков, Зимин, " +
            "Гелетей, Бачей, Красильников, Ковалёв, Трублаевский, Кулишенко, Фомичёв";
    public static String lainFirstName = "Конрад, Филипп, Шерлок, Харитон, Тимофей, Иосиф, Устин, Зенон, Чарльз, Юлиан, Шарль, Леон, " +
            "Йонас, Артём, Йосып, Ждан, Абрам, Лоренс, Вадим, Цефас, Герасим, Эдуард, Гордей, Назар, Бронислав, Оскар, Гордей, " +
            "Харитон, Фёдор, Юлий";
    public static String lainPatronymic = "Дмитриевич, Борисович, Викторович, Владимирович, Сергеевич, Львович, Петрович, Андреевич, " +
            "Вадимович, Юхимович, Фёдорович, Эдуардович, Андреевич, Платонович, Григорьевич, Богданович, Станиславович, Алексеевич, " +
            "Максимович, Станиславович, Михайлович, Валериевич";
    public static String lainPosition = "ген. Директор, Директор, зам. Директора, гл. Бухгалтер, Бухгалтер, гл. Инженер, Иженер, " +
            "Механик, Бригадир, Слесарь, Плотник, Стропольщик, Крановщик, Кладовщик, Водитель, Грузчик, Сторож, Столяр, Геодезист, " +
            "Менеджер, Продавец, Экспедитор";

    public static void main(String[] args) {
        int[] arr = new int[2];
        Employee employee = new Employee();
        System.out.println("Введите количество сотрудников для создания массива.");
        int x = theNumberOfEmployees();
        Employee[] arrayEmployee = new Employee[x];
        arrayBuilding(arrayEmployee, employee, x);
        System.out.println("""
                        Для сортировки сотрудников по возрасту введите ограничения в формате
                        30 -  (30 пробел - ) или 30 + (30 пробел + )
                        ---> "(PS: (30 -) - Не старше 30 лет  (30 +) - Старше 30 лет.)""");
        arr = examination();
        arraySorting(arrayEmployee, arr);
    }


    private static int[] examination() {
        int[] arr;
        while (true) {
            try {
                arr = getNumberFromScanner("Ограничение по возрасту сотрудников от 20 до 65 лет." +
                        "выполнения программы :(.", 20, 65);
                return arr;
            } catch (NumberFormatException e) {
                System.out.println("""
                        Чтото ввели не так.
                        "Для сортировки сотрудников по возрасту введите ограничения в формате
                        30 -  (30 пробел - ) или 30 + (30 пробел + )
                                         "(PS: 30- - Не старше 30 лет  30+ - Старше 30 лет.)""");
            }
        }
    }

    public static int[] getNumberFromScanner(String message, int min, int max) {
        int a;
        int[] arr = new int[2];
        do {
            String[] text = se.nextLine().split(" ");
            a = Integer.parseInt(text[0]);
            String y = text[1];
            if (a >= 20 && a <= 65) {
                arr[0] =a;
                do {
                    if (y.equals("-")) {
                        arr[1] = -1;
                        return arr;
                    } else {
                        if (y.equals("+")) {
                            arr[1] = 1;
                            return arr;
                        }
                    }
                    if (!y.equals("-") || !y.equals("+")) {
                        System.out.println(y + " - Данные значения не соответсвуют ожидаемым введите плюс - (+)  или минус - (-)");
                        y = se.nextLine();
                        if (y.equals("-")) {
                            arr[1] = -1;
                            return arr;
                        } else {
                            if (y.equals("+")) {
                                arr[1] = 1;
                                return arr;
                            }
                        }
                    }
//                    System.out.println(message);
                } while (arr[1] != -1 || arr[1] != 1);
            }
            System.out.println(message);
        } while (a < min || a > max);
        return arr;
    }

    private static void arrayBuilding(Employee[] arrayEmployee, Employee employee, int x) {
        int i;
        System.out.println("Сформирован список из - " + x + " сотрудников.");
        System.out.println("- - - - - - - - - - - - - - - - - - - -");

        for (i = 0; i < x; i++) {
            arrayEmployee[i] = employee.clone(i);
            employee.print(arrayEmployee[i]);
        }
        System.out.println("Количество сотрудников в списке - " + i);
        System.out.println("--------------------------------------");
    }

    private static void arraySorting(Employee[] arrayEmployee, int[] arr) {
        int i;
        int j = 0;
        int x = arr[0];
        int a = arr[1];
        if (a == 1) {
            System.out.println("Сформирован список сотрудников кому исполнилось - " + x + " лет и старше.");
        }
        if (a == -1) {
            System.out.println("Сформирован список сотрудников кому исполнилось - " + x + " лет и младше.");
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        for (i = 0; i < arrayEmployee.length; i++) {
            if (a == 1) {
                if (arrayEmployee[i].getAge() >= x) {
                    arrayEmployee[i].print(arrayEmployee[i]);
                    j++;
                }
            } else if (a == -1) {
                if (arrayEmployee[i].getAge() <= x) {
                    arrayEmployee[i].print(arrayEmployee[i]);
                    j++;
                }
            }
        }
        System.out.println("Количество сотрудников в списке - " + j);
        System.out.println("--------------------------------------");
    }

    public static int theNumberOfEmployees() {
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
