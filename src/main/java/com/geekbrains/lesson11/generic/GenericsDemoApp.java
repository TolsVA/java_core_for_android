package com.geekbrains.lesson11.generic;

public class GenericsDemoApp {
    public static void main(String args[]) {
        TestGeneric<String> genStr = new TestGeneric<>("Hello");
        genStr.showType();
        System.out.println("genStr.getObject(): " + genStr.getObj());
        TestGeneric<Integer> genInt = new TestGeneric<>(140);
        TestGeneric<Integer> genInt2 = new TestGeneric<>(15);
        genInt.showType();
        System.out.println("genInt.getObject(): " + genInt.getObj());
        int valueFromGenInt = genInt.getObj();
        String valueFromGenString = genStr.getObj();
        System.out.println(valueFromGenInt);
        System.out.println(valueFromGenString);
        // genInt.setObj("Java"); // Ошибка компиляции неправильное приведение типов в int ложем String!!!
         genInt = genInt2;
        System.out.println(genInt.getObj());
        //genInt = genStr;  // Ошибка
    }
}
