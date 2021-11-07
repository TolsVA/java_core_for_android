package com.geekbrains.lesson1;

import java.util.Scanner;

public class Homework1 {

    public static void main(String[] args) {
        byte byte1 = (byte) 128; // -128/127
        short short1 = (short) 100;
        int int1 = 225; // -2147483648 до 2147483647
        long long1 = 300;

        float float1 = 1.2f;
        double double1 = 1.2;

        char char1 = 'a';
        char char2 = 'b';

        boolean boolean1 = false;
        boolean boolean2 = true;

        final String string1 = "Тестируем строки."; // final - означает (константу) что переменную нельзя изменить

        int int2 = 50;
        System.out.println(int1 +"/" + int2 + " - " + int1/int2 + " целых " + int1%int2 + "/" + int2);

        int sum = 0;
        sum += 200;
        System.out.println(++sum); // Выведит 201

        float a = 5f;
        float b = 10f;
        float d = a + b;  // = 15
        float c = b + d - a;  // = 20
        float y = sum(a, b, d, c);  //  a * (b + (c / d))

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("d = " + d);
        System.out.println("с = " + c);
        System.out.println("y = " + y);
        sumAndPrint(a, b, d); // = 85

        System.out.println(string1);

//      Понемаю бестолковое занятие отправлять строку в метод чтобы обратно её получить
//      но ведь получилось.
        System.out.println(printSomething("Привет "));
        System.out.println("x = " + int1);
        System.out.println("y = " + int2);
        System.out.println("10 <= (x + x) <= 20 " + task10and20(int1,int2));

        SecondLesson.print();

        isPositiveOrNegative(byte1);
        System.out.println("ВВЕДИТЕ ГОД ДЛЯ РАСЧЕТА ВЫСОКОСНОГО ГОДА ОТ - БЕСКОНЕЧНОСТИ ДО + БЕСКОНЕЧНОСТИ!!!");
        Scanner in = new Scanner(System.in);

        System.out.println("Всего высокосных лет - " + year(in.nextInt()));

        System.out.println(isNegative(short1));
        System.out.println(isNegative(byte1));
    }

    /**
     * 3. Метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат, имеющий тип float.
     * @param a первое число
     * @param b второе число
     * @param d третье число
     * @param c четвертое число
     * @return Сумма этих чисел
     */
    public static float sum(float a, float b, float d, float c) {return a * (b + (c / d)) ;}

    //  4. Метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит
//     в пределах от 10 до 20 (включительно), если да – возврашает true, нет – false.
    public static boolean task10and20(int x1, int x2) {
        int x = x1 + x2;
        return x >= 10  && x2 <= 20;
    }
    //  5. Метод, которому в качестве параметра передается целое число,
//     метод должен напечатать в консоль, положительное ли число передали или отрицательное.
//     Замечание: ноль считаем положительным числом.
    public static void isPositiveOrNegative(byte x) {
        if(x < 0) {
            System.out.println("(" + x + ") - Значение отрицательное");
        } else {
            System.out.println(x + "Значение положительное");
        }
    }

    //  6. Метод, которому в качестве параметра передается целое число.
//     Метод возвращае true, если число отрицательное, и вернуть false если положительное.
    public static boolean isNegative(int x){return x <= 0;}

    //  7. Написать метод, которому в качестве параметра передается строка,
//     обозначающая имя. Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    public static String printSomething(String strings) {return strings + "Виталя!";}

    /**
     * Метод отображает в консоле сумму значений
     * @param a Первое значение
     * @param b Второе значение
     * @param d Третье значение
     */
    public static void sumAndPrint(float a, float b, float d) {
        float z = sum(a, d, a, b);
        System.out.println("z = " + z);
    }

    //    8. Метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
//       Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static int year(int y) {
        int x = y/4 - ((3 * (y/400)) + ((y % 400)/100));
        if (y % 4 == 0) {
            if ((y/100) == 0) {
                System.out.println(y + " - год высокосный");
            } else if ((y/100) > 0){System.out.println(y + " - год высокосный");}
        } else {System.out.println(y + " - год НЕ высокосный");}
        return x;
    }
}
