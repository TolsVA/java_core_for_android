package com.geekbrains.lesson11.generic2;

public class SimpleGenApp {
    public static void main(String args[]) {
        TwoGen<Integer, String> twoGenObj = new TwoGen<Integer, String>(555, "Hello");
        TwoGen<String, Integer> twoGenObj1 = new TwoGen<String, Integer>("Привет", 666);
        twoGenObj.showTypes();
        twoGenObj1.showTypes();
        int intValue = twoGenObj.getObj1();
        String strValue = twoGenObj.getObj2();
        System.out.println(intValue);
        System.out.println(strValue);
    }
}
