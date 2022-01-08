package com.geekbrains.lesson11_2.collections;

import java.util.Arrays;

public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    transient Object[] elementData;
    private int size;
    private int capacity;

    public int getSize() {
        return size;
    }

    public T getItem(int i) {
        return (T) elementData[i];
    }

    public MyArrayList(T[] arr) {
        capacity = arr.length;
        elementData = arr;
        size = capacity;
        for (int i = 0; i < capacity; i++) {
            if(elementData[i] == null){
                size--;
            }
        }
        capacity = size;
    }

    public MyArrayList() {
        capacity = DEFAULT_CAPACITY;
        elementData = new Object[capacity];
    }

    public void add(T _item) {
        if(size == elementData.length) {
            resize(elementData.length);
        }
        elementData[size++] = _item;
    }

    public void add(String s, MyLinkedList<T> _item) {
        if(size == elementData.length) {
            resize(elementData.length);
        }
        elementData[size++] = s + _item;
    }


    public void add(int index, T _item) {
        if(size == elementData.length) {
            resize(elementData.length);
        }
        try {
            if (index < size || index > 0) {
                System.arraycopy(elementData, index, elementData, index + 1, size - index);
                elementData[index] = _item;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException Элемент не добавлен индекс выходит за границы size");
        }
    }


    private void resize(int oldCapacity) {
        capacity = oldCapacity + 1 + (oldCapacity >> 1);
        Object[] newArray = new Object[capacity];
        System.arraycopy(elementData, 0, newArray, 0, size);
        elementData = newArray;
    }

    public void equalizeSizeLength() {
        capacity = size;
        Object[] newArray = new Object[capacity];
        System.arraycopy(elementData, 0, newArray, 0, size);
        elementData = newArray;
    }

    public String showType() {
        return "Тип T: " + getClass().getName();
    }

    public void change(int i, int j) {
        addObject(elementData[i]);
        elementData[i] = elementData[j];
        elementData[j] = elementData[size-1];
        remove(size-1);
    }

    private void addObject(Object elementDatum) {
        if(size == elementData.length) {
            resize(elementData.length);
        }
        elementData[size++] = elementDatum;
    }

    private void remove(int index) {
        for (int i = index; i < size; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[size] = null;
        size--;
    }

    @Override
    public String toString() {
        return Arrays.asList(elementData) + " - MyArrayList ";
    }

}





