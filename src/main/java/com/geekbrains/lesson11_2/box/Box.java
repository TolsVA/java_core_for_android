package com.geekbrains.lesson11_2.box;

import com.geekbrains.lesson11_2.collections.MyArrayList;
import com.geekbrains.lesson11_2.collections.MyLinkedList;
import com.geekbrains.lesson11_2.fruit.Fruit;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Box<T extends Fruit>{
    private float fruitWeight;
    private final MyLinkedList<T> fruitMyLinkedListBox;
    private MyArrayList<Fruit> myArrayListBox;

    public Box() {
        this.fruitWeight = 0;
        this.fruitMyLinkedListBox = new MyLinkedList<>();
    }

    public MyLinkedList<T> getFruitMyLinkedListBox() {
        return fruitMyLinkedListBox;
    }

    public void setFruitMyLinkedListBox(T fruit) {
        fruitMyLinkedListBox.addLast(fruit);
        fruitWeight += fruitMyLinkedListBox.getLast().getWeight();
    }

    public float getFruitWeight() {
        return fruitWeight;
    }

    public void setMyArrayListBox(String s, MyLinkedList<Fruit> _box) {
        if (myArrayListBox == null) {
            myArrayListBox = new MyArrayList<>();
        }
        myArrayListBox.add(s + " ", _box);
    }

    public MyArrayList<Fruit> getMyArrayListBox() {
        return myArrayListBox;
    }

    public void compareWeight(Box<T> box) {
        BigDecimal decimal1 = new BigDecimal(this.fruitWeight);
        float d = Float.parseFloat(String.valueOf(decimal1.setScale(1, RoundingMode.HALF_DOWN)));

        BigDecimal decimal2 = new BigDecimal(box.fruitWeight);
        float s = Float.parseFloat(String.valueOf(decimal2.setScale(1, RoundingMode.HALF_DOWN)));

        if (Math.abs(d - s) < 0.0001) {
            System.out.println(d + " == " + s);
        } else {
            System.out.println(d + " != " + s);
        }

    }

}
