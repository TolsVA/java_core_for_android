package com.geekbrains.lesson11_2.array;

public class MainArray {
    public static void main(String[] args) {
        Integer[] arr = new Integer[10];

        for (int i = 0 ; i < arr.length; i++ ) {
            arr[i] = (int) Math.round(Math.random() * (arr.length - 1));
        }

        int i = (int) Math.round(Math.random() * (arr.length - 1));
        int j = (int) Math.round(Math.random() * (arr.length - 1));

        print("Создан массив arr = new Integer[10]", "   -   Выбрано для замены местами - arr[" + i + "] = " + arr[i] + "" +
                " / arr[" + j + "] = " + arr[j], arr);

        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.change(i, j, arr);

        print("", "   -   Массив Integer[] arr преобразован в MyArrayList<Integer> myArrayList  - " +
                myArrayList.showType() + "\n\t\t\t\t\t       И заменены местами - arr[" + i + "] = " + arr[i] +
                " / arr[" + j + "] = " + arr[j]+ "\n", arr);

        int n = 2;
        for (int f = -n; f <= n; f += n * 2) {
            shift(arr, f);
        }
    }

    private static void print(String s, String s1, Integer[] arr) {
        System.out.println(s);
        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
        System.out.print(s1);
    }

    public static void shift(Integer [] arr, int n) {
        int[] arr1 = new int[]{0, arr.length - 1};
        int s = Math.abs(n)/n;
        String message;
        if (s < 0) {
            int h = arr1[1];
            arr1[1] = arr1[0];
            arr1[0] = h;
            message = "   -   Сдвиг на " + Math.abs(n) + " в право";
        } else {
            message = "   -   Сдвиг на " + Math.abs(n) + " в лево";
        }
        for (int a = 0; a < Math.abs(n); a++) {
            int d = arr[arr1[0]];
            for (int b = arr1[0]; b != arr1[1]; b+=s) {
                arr[b] = arr[b+s];
            }
            arr[arr1[1]] = d;
        }
        print("", message, arr);
    }
}
