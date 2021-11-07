package com.geekbrains.lesson2;

import java.util.Arrays;

public class Homework2 {
    static int example = 0;
    public static void main(String[] args) {

        int [] array = {1, 0, 1, 0, 0, 1};
        print(array);

        int [] arr = new int [8];
        plusThree(arr);

        int [] arr1 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        sixTimesTwo(arr1);

        char [][] arr2 = new char[5][5];
        diagonals(arr2);

        int [] arr3 = new int [50];
        minMax(arr3);

        int [] arr4 = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println("  >>> " + checkBalance(arr4));

        int [] arr5 = new int[10];
        int n = -3;
        for (int i = 0 ; i < arr5.length; i++ ) {
            arr5[i] = (int) Math.round((Math.random() * arr5.length));
            System.out.print(arr5[i] + " ");
        }
        System.out.println();
        shift(arr5, n);
    }

    //  1. Задча
    public static void print(int [] arr) {
        for (int i = 0 ; i<arr.length;i++) System.out.print(arr[i] + " ");
        System.out.println(" - Заданный массив");
        for(int i = 0 ; i<arr.length;i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else arr[i] = 0;
            System.out.print(arr[i] + " ");
        }
        System.out.println(" - Полученый массив\n");
    }

    //  2. Задача
    public static void plusThree(int [] arr) {
        for (int i = 0 ; i<arr.length; i++) {
            if (i == 0) {
                arr[i] = i;
                System.out.print(arr[i] + " ");
            } else {
                arr[i] = arr[i-1] +3;
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println("\n");
    }

    //  3. Задача
    public static void sixTimesTwo(int [] arr) {
        for (int i = 0 ; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }System.out.print("   - Заданный массив.\n");
        for (int i = 0 ; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] = arr[i] *2;
            System.out.print(arr[i] + " ");
        }System.out.println(" - Полученый массив.\n");
    }

    //    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
//    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void diagonals(char [][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if ( i == j || j == arr.length - (1 + i)) {
                    arr[i][arr.length - (1 + i)] = 'X';
                    System.out.print(arr[i][arr.length - (1 + i)]+ "\t");
                } else  {
                    arr[i][j] = '.';
                    System.out.print(arr[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    //    5. ** Задать одномерный массив и найти в нем минимальный
//          и максимальный элементы (без помощи интернета);
    public static void minMax(int [] arr) {
        for (int i = 0 ; i < arr.length; i++ ) {
            arr[i] = (int) Math.round((Math.random() * arr.length));
            System.out.print(arr[i] + " ");
        }
        Arrays.sort(arr);
        System.out.println("\nМинимальное значение  - " + arr[0] + "\nМаксимальное значение - " + arr[arr.length-1]);
    }

    //    6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
//    метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
//    Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
//    checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
    public static boolean checkBalance(int [] arr) {
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int a = 0;
        for (int i = 0 ; i < arr.length; i++ ) {
            sum1 = sum1 + arr[i];
        }
        sum2 = sum1;
        for (int i = 0 ; i < arr.length; i++ ) {
            System.out.print(arr[i] + " ");
            sum2 = sum2 - arr[i];
            sum3 = sum3 + arr[i];
            if (sum2 == sum3) {
                a++;
                System.out.print(arr[i] + " || ");
            }
        }
        return a > 0;
    }

//    7. **** Написать метод, которому на вход подается одномерный массив
//    и число n (может быть положительным, или отрицательным),
//    при этом метод должен сместить все элементы массива на n позиций.
//    Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
//    Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
//    [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
//    При каком n в какую сторону сдвиг можете выбирать сами.

    public static void shift(int [] arr, int n) {
        for (int a = 0, y = 0; a < Math.abs(n); a++) {
            int d = arr[y];
            for (int b = 0; b < arr.length - 1; b++) {
                arr[b] = arr[b + 1];
            }
            arr[arr.length - 1] = d;
        }
        for (int x = 0; x < arr.length; x++) {
            System.out.print(arr[x] + " ");
        }
    }
}
