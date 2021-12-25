package com.geekbrains.lesson9_2;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(String message) {
        super("MyArrayDataException - " + message);
    }
}
