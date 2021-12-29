package com.geekbrains.lesson11_2;

import com.geekbrains.lesson11_2.fruit.Apple;
import com.geekbrains.lesson11_2.fruit.Orange;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        float wtApple = 1.0f;
        float wtOrange = 1.5f;
        Apple apple1 = new Apple(wtApple, 10);
        Apple apple2 = new Apple(wtApple, 25);
        Orange orange1 = new Orange(wtOrange,15);
        Orange orange2 = new Orange(wtOrange, 30);


    }
}
