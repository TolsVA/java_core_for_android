package com.geekbrains.lesson8_2;

public class ClientOne implements Callback {
    public void callback(int param) {
        System.out.println("ClientOne param: " + param);
    }
}
