package com.geekbrains.lesson1;

public class SecondLesson {
    public static void print() {
        int x1 = 5;
        int x2 = 10;
        float d = 10f;
        float c = x2 - x1;
        System.out.println("x1 = " + x1);
        System.out.println("x2 = " + x2);
        System.out.println("10 <= (x1 + x2) <= 20 " + Homework1.task10and20(x1, x2));
        System.out.println("a = " + x1);
        System.out.println("b = " + x2);
        System.out.println("d = " + d);
        System.out.println("c = b - a = " + c);
        float x = Homework1.sum(x1 ,x2, d, c);
        System.out.println("a * (b + (c / d) = " + x);
    }
}
