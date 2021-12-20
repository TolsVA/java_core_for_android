package com.geekbrains.lesson8_2;

public class Client implements Callback {

   // имплементация метода callback() интерфейса Callback
    public void callback(int param) {

        System.out.println("param: "+param);
    }

    // метод самого класса
    public void info() {

        System.out.println("Client Info");
    }

}
