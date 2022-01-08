package com.geekbrains.lesson11_2;

import com.geekbrains.lesson11_2.collections.MyArrayList;

public class Print {

    public <T> void printValue(String s, String s1, T[] arr) {
         System.out.println(s);
        for (T t : arr) {
            System.out.print(t + " ");
        }
         System.out.print(s1);
    }

    public <T> void printValue(String s, String s1, MyArrayList<T> myArrayList) {
        System.out.println(s);
        for (int i = 0; i < myArrayList.getSize(); i++) {
            System.out.print(myArrayList.getItem(i) + " ");
        }
        System.out.print(s1);
    }
}
