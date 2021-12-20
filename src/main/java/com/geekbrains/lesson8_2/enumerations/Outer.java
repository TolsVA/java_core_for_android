package com.geekbrains.lesson8_2.enumerations;

public class Outer {
    public static void main(String[] args) {

        Inner.innerTest();
        outerTest();
        Inner.innerTest();
    }
    static class Inner {
        private static int innerVar;

        public Inner(int innerVar) {
            this.innerVar = innerVar;
        }

        static void innerTest() {
            System.out.println("innerVar: " + innerVar);
            System.out.println("outerVar: " + outerVar);
        }
    }

    private static int outerVar;

    public Outer(int outerVar) {
        this.outerVar = outerVar;
    }

    public static void outerTest() {
        Outer outer = new Outer(15);

        System.out.println("outerVar: " + outerVar);
        // System.out.println("innerVar: " + innerVar); //тут ошибка
        Inner io = new Inner(20);
        System.out.println("io.innerVar = " + io.innerVar);
    }
}
