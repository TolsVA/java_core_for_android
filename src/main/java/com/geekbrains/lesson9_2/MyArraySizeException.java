package com.geekbrains.lesson9_2;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException{
    public MyArraySizeException(String message) {
        super("MyArraySizeException - " + message);
    }
}
