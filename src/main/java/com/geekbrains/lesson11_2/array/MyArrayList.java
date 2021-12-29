package com.geekbrains.lesson11_2.array;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList<T> {

    public String showType() {
        return "Тип T: " + getClass().getName();
    }

    public <E> void change(int i, int j, E[] arr) {
        E variable = arr[i];
        arr[i] = arr[j];
        arr[j] = variable;
    }

    public ArrayList<T> ArrayToArrayList(T[] array) {
        return new ArrayList<>(List.of(array));
    }
}
