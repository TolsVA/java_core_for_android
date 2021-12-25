package com.geekbrains.lesson9;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

//        int a, b;
//        try {
//            a = 0;
//            b = 10 / a;
//            System.out.println("Это сообщение не будет выведено в консоль");
//        } catch (ArithmeticException e) {
//            System.out.println("Деление на ноль"); }
//        System.out.println("Завершение работы");


//        System.out.println("Начало");
//        try {
//            int а = 0;
//            int b = 42 / а;
//        } catch (ArithmeticException e) {
//            e.printStackTrace(); }
//        System.out.println("Конец");


        int i;
        for (i = 0; i < 2; i++) {
            try {
                int a = 1;
                a -= i;
                int b = 42 / a;
                int[] с = {1, 2, 3};
                с[42] = 99;

            } catch (ArithmeticException e) {
                System.out.println("Дeлeниe на ноль: " + e);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Ошибка индексации массива: " + e);
            }
            System.out.println("Пocлe блока операторов try/catch");
        }
        System.out.println("Завершение цикла");


//        ////
//        try {
//            int а = 0;
//            int b = 42 / а;
//        } catch (Exception е) {
//            System.out.println("Exception");
//        } catch (ArithmeticException е) { // ошибка компиляции: недостижимый код !
//            System.out.println("Этот код недостижим"); }
//
//        try {
//            int а = 0;
//            int b = 42 / а;
//        } catch (ArithmeticException е) {
//            System.out.println("Этот код ДОСТИЖИМ");
//        } catch (Exception е) {
//            System.out.println("Exception");
//        }
//        //////


//        try {
//            throw new NullPointerException("NPE Test");
//        } catch (NullPointerException е) {
//            System.out.println("Catch block");
//        }


        try {
            createReport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void createReport() throws IOException {
        PrintWriter pw = new PrintWriter("report.txt");
        pw.close(); }

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
