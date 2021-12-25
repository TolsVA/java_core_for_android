package com.geekbrains.lesson9_2;

import java.util.Arrays;

public class Homework9 {
    private static int SUM;
    public static void main(String[] args) {
        String[][] arr = new String[0][0];
        for (int i = 3; i <= 4; i++) {
            arr = MyArray(new String[i][i]);
        }
        System.out.println("""
                |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
                | Двумерный строковый массив arr[4][4] всё таки создался |
                |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|""");
        System.out.println("|" + Arrays.deepToString(arr) + "                     |");
        System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|\n" +
                "|   Сумма элементов массива без исключений равна - " + getSUM() + "   |\n" +
                "|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
    }

    private static String[][] MyArray(String[][] arr) {
        try {
            if (arr.length != 4) {
                throw new MyArraySizeException("массив не верного размера - arr[" + arr.length + " != 4][ ]");
            }
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <= arr.length; i++) {  //Выход индекса за пределы массива | массив не верного размера
            try {
                if (arr[i].length != 4) {
                    throw new MyArraySizeException("массив не верного размера - arr[4][" + arr[i].length + " != 4]");
                }
            } catch (MyArraySizeException e) {
                e.printStackTrace();
                return arr;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndexOutOfBoundsException - Выход индекса за пределы массива");
                return arr;
            }
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = String.format("%s%s", i, j);
                if (j == 0) {
                    if (i == 0) {
                        try {
                            int m = 100/Integer.parseInt(arr[i][j]);
                            System.out.println(m);
                        } catch (ArithmeticException e) {
                            System.out.println(e + " - ArithmeticException: 100 / (arr[" + i + "][" + j + "] = " +
                                    Integer.parseInt(arr[i][j]) + ") Деление на 0 невозможно");
                        }
                        setSUM(Integer.parseInt(arr[i][j]));
                        arr[i][j] = String.format("\f\b\b                 [%s%s", i, j);
                    } else {
                        setSUM(Integer.parseInt(arr[i][j]));
                        arr[i][j] = String.format("\f\b\b\t\t\t\t\t |%n|                  [%s%s", i, j);
                    }
                } else {
                    try {
                        if (String.format("%s%s", i, j).equals("13")) {
                            arr[i][j] = null;
                            throw new MyArrayDataException("arr[" + i + "][" + j + "] = " + arr[i][j] + " Невозможно проанализировать пустую строку");
                        }
                        setSUM(Integer.parseInt(arr[i][j]));

                    } catch (MyArrayDataException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println();
        return arr;
    }

    public static void setSUM(int SUM) {
        Homework9.SUM += SUM;
    }

    public static int getSUM() {
        return SUM;
    }
}
