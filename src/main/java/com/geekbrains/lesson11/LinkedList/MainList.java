package com.geekbrains.lesson11.LinkedList;

import java.util.LinkedList;

public class MainList {
    public static void main(String[] args) {
        MyLinkedList<Integer> integerMyLinkedList = new MyLinkedList<>();
        LinkedList<Integer> f = new LinkedList<>();
        integerMyLinkedList.addNode(120);
        integerMyLinkedList.addNode(150);
        integerMyLinkedList.addNode(210);
        integerMyLinkedList.addNode(100);

        integerMyLinkedList.display();
        integerMyLinkedList.display(1);


    }
}
