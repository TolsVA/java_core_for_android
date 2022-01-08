package com.geekbrains.lesson11_2;

import com.geekbrains.lesson11_2.box.Box;
import com.geekbrains.lesson11_2.collections.MyArrayList;
import com.geekbrains.lesson11_2.collections.MyLinkedList;
import com.geekbrains.lesson11_2.fruit.Apple;
import com.geekbrains.lesson11_2.fruit.Fruit;
import com.geekbrains.lesson11_2.fruit.Orange;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = new Integer[10];

        for (int i = 0 ; i < arr.length; i++ ) {
            arr[i] = (int) Math.round(Math.random() * (arr.length - 1));
        }

        int i = (int) Math.round(Math.random() * (arr.length - 1));
        int j = (int) Math.round(Math.random() * (arr.length - 1));

        MyArrayList<Integer> myArrayList = new MyArrayList<>(arr);

        Print print = new Print();
        print.printValue("Создан массив arr = new Integer[10]", "   -   Выбрано для замены местами - arr[" + i + "] = " + arr[i] + "" +
                " / arr[" + j + "] = " + arr[j], arr);

        myArrayList.change(i, j);
        print.printValue("", "   -   Массив Integer[] arr преобразован в MyArrayList<Integer> myArrayList  - " +
                myArrayList.showType() + "\n\t\t\t\t\t       И заменены местами - myArrayList[" + i + "] = " + myArrayList.getItem(i) +
                " / myArrayList[" + j + "] = " + myArrayList.getItem(j)+ "\n", myArrayList);

        int n = 2;
        for (int f = -n; f <= n; f += n * 2) {
            shift(arr, f);
        }

        float appleWeight = 0;
        float orangeWeight = 0;
        int numberFruits = 100;

        MyLinkedList<Fruit> myLinkedListFruits = new MyLinkedList<>();

        int apple = 0;
        int orange = 0;
        for (int s = 0; s < numberFruits; s++) {
            int b = (int) (Math.random() * 2);
            if (b == 0) {
                myLinkedListFruits.addLast(new Apple());
                appleWeight += myLinkedListFruits.getIndex(s).getWeight();
                apple++;
            } else {
                myLinkedListFruits.addLast(new Orange());
                orangeWeight += myLinkedListFruits.getIndex(s).getWeight();
                orange++;
            }
        }

        BigDecimal decimal = new BigDecimal(appleWeight);
        appleWeight = Float.parseFloat(String.valueOf(decimal.setScale(1, RoundingMode.HALF_DOWN)));

        BigDecimal decimal1 = new BigDecimal(orangeWeight);
        orangeWeight = Float.parseFloat(String.valueOf(decimal1.setScale(1, RoundingMode.HALF_DOWN)));
        System.out.println();

        BigDecimal decimal2 = new BigDecimal(appleWeight + orangeWeight);
        float f = Float.parseFloat(String.valueOf(decimal2.setScale(1, RoundingMode.HALF_DOWN)));

        System.out.printf("""
                
                MyLinkedList<Fruit>  содержит: |---------------------------------|
                                               | Наименование  | Кол-во | Вес кг.|
                                               |---------------|--------|--------|
                                               | Яблоки        | %s     | %s   |
                                               | Апельсины     | %s     | %s   |
                                               |---------------|--------|--------|
                                               | Итого фруктов | %s    | %s  |
                                               |---------------|--------|--------|
                 """, apple, appleWeight, orange, orangeWeight, apple + orange, f);

        System.out.println();
        System.out.println(myLinkedListFruits);

        MyLinkedList<Fruit> myLinkedListBoxFruit1 = new MyLinkedList<>();
        MyLinkedList<Fruit> myLinkedListBoxFruit2 = new MyLinkedList<>();

        Box<Fruit>[] boxes = new Box[numberFruits];

        int f1 = 0;
        int f2 = 1;
        boxes[f1] = new Box<>();
        boxes[f2] = new Box<>();
        float weightFruit1 = 0;
        float weightFruit2 = 0;
        int fr = 0;
        int boxFruit1 = 0;
        int boxFruit2 = 0;

        int fruit1 = 0;
        int fruit2 = 0;

        boxes[f1].setFruitMyLinkedListBox(myLinkedListFruits.getFirst());
        fr++;
        fruit1++;
        String boxesClassName = boxes[f1].getFruitMyLinkedListBox().getLast().getClass().getName();
        myLinkedListFruits.removeFirst();

        ListIterator<Fruit> iterator = myLinkedListFruits.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
            if (boxesClassName.equals(iterator.previous().getClass().getName())) {
                iterator.next();
                boxes[f1].setFruitMyLinkedListBox(iterator.previous());
                fr++;
                fruit1++;
                if (boxes[f1].getFruitWeight() >= 20) {
                    boxFruit1++;
                    weightFruit1 += boxes[f1].getFruitWeight();
                    myLinkedListBoxFruit1.addLast("\n\n" + boxFruit1 + " - Коробка " + boxes[f1].getFruitMyLinkedListBox().getFirst().getName() + " вес: " +
                        Float.parseFloat(String.valueOf(BigDecimal.valueOf(boxes[f1].getFruitWeight()).setScale(1, RoundingMode.HALF_DOWN))) +
                        "\n", boxes[f1].getFruitMyLinkedListBox());
                    f1 += 2;
                    boxes[f1] = new Box<>();
                }
            } else {
                iterator.next();
                boxes[f2].setFruitMyLinkedListBox(iterator.previous());
                fr++;
                fruit2++;
                if (boxes[f2].getFruitWeight() >= 20) {
                    boxFruit2++;
                    weightFruit2 += boxes[f2].getFruitWeight();
                    myLinkedListBoxFruit2.addLast("\n\n" + boxFruit2 + " - Коробка " + boxes[f2].getFruitMyLinkedListBox().getFirst().getName() + " вес: " +
                            Float.parseFloat(String.valueOf(BigDecimal.valueOf(boxes[f2].getFruitWeight()).setScale(1, RoundingMode.HALF_DOWN))) +
                            "\n", boxes[f2].getFruitMyLinkedListBox());
                    f2 += 2;
                    boxes[f2] = new Box<>();
                }
            }
            iterator.remove();
            iterator.next();
        }
        if (boxesClassName.equals(myLinkedListFruits.getIndex(0).getClass().getName())) {
            boxes[f1].setFruitMyLinkedListBox(myLinkedListFruits.getIndex(0));
            fruit1++;
        } else {
            boxes[f2].setFruitMyLinkedListBox(myLinkedListFruits.getIndex(0));
            fruit2++;
        }
        fr++;
        weightFruit1 += boxes[f1].getFruitWeight();
        weightFruit2 += boxes[f2].getFruitWeight();
        boxFruit1++;
        if (boxes[f1].getFruitMyLinkedListBox() != null) {
            myLinkedListBoxFruit1.addLast("\n\n" + boxFruit1 + " - Коробка " + boxes[f1].getFruitMyLinkedListBox().getLast().getName() + " вес: " +
                    Float.parseFloat(String.valueOf(BigDecimal.valueOf(boxes[f1].getFruitWeight()).setScale(1, RoundingMode.HALF_DOWN))) +
                    "\n", boxes[f1].getFruitMyLinkedListBox());
        }

        boxFruit2++;
        if (boxes[f2].getFruitMyLinkedListBox() != null) {
            myLinkedListBoxFruit2.addLast("\n\n" + boxFruit2 + " - Коробка " + boxes[f2].getFruitMyLinkedListBox().getLast().getName() + " вес: " +
                    Float.parseFloat(String.valueOf(BigDecimal.valueOf(boxes[f2].getFruitWeight()).setScale(1, RoundingMode.HALF_DOWN))) +
                    "\n", boxes[f2].getFruitMyLinkedListBox());
        }

        iterator.remove();

        BigDecimal decimal3 = new BigDecimal(weightFruit1);
        float a = Float.parseFloat(String.valueOf(decimal3.setScale(1, RoundingMode.HALF_DOWN)));

        BigDecimal decimal4 = new BigDecimal(weightFruit2);
        float o = Float.parseFloat(String.valueOf(decimal4.setScale(1, RoundingMode.HALF_DOWN)));

        Box<Fruit> box = new Box<>();
        box.setMyArrayListBox("""

                +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                Коробка с коробками""" + " " + boxes[f1].getFruitMyLinkedListBox().getLast().getName() + ": Кол-во коробок - " + boxFruit1 +
                " шт. Кол-во " + boxes[f1].getFruitMyLinkedListBox().getLast().getName() + " - " + fruit1 + " шт. Вес - " + a + " кг." + """

                +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                """,  myLinkedListBoxFruit1);
        box.setMyArrayListBox("""


                +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                Коробка с коробками""" + " " + boxes[f2].getFruitMyLinkedListBox().getLast().getName() + ": Кол-во коробок - " + boxFruit2 +
                " шт. Кол-во " + boxes[f2].getFruitMyLinkedListBox().getLast().getName() + " - " + fruit2 + " шт. Вес - " + o + " кг." + """

                +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                """, myLinkedListBoxFruit2);

        box.getMyArrayListBox().equalizeSizeLength();
        BigDecimal decimal5 = new BigDecimal(weightFruit1 + weightFruit2);
        float d = Float.parseFloat(String.valueOf(decimal5.setScale(1, RoundingMode.HALF_DOWN)));

        System.out.printf("""
               ==============================================================================================================
               БОЛЬШАЯ КОРОБКА С КОРОБКАМИ ФРУКТОВ:  Кол-во коробок""" + " - " + (boxFruit1 + boxFruit2) + " шт.  Общий вес - " + " " + d  +
                " кг.  Кол-во фруктов - " + fr + " шт." + """

               ==============================================================================================================
                %s""", box.getMyArrayListBox());
        System.out.println();
        System.out.println(myLinkedListFruits);

        for (int s = 0; s < myLinkedListBoxFruit1.size()*2; s += 2) {
            for (int g = 1; g < myLinkedListBoxFruit2.size()*2; g += 2) {
                try {
                    boxes[s].compareWeight(boxes[g]);
                } catch (NullPointerException e) {
                    System.out.println("Одна из коробок пустая.");
                }
            }
        }
    }

    public static void shift(Integer [] arr, int n) {
        int[] arr1 = new int[]{0, arr.length - 1};
        int s = Math.abs(n)/n;
        String message;
        if (s < 0) {
            int h = arr1[1];
            arr1[1] = arr1[0];
            arr1[0] = h;
            message = "   -   Сдвиг на " + Math.abs(n) + " в право. Массив Integer [] arr";
        } else {
            message = "   -   Сдвиг на " + Math.abs(n) + " в лево. Массив Integer [] arr";
        }
        for (int a = 0; a < Math.abs(n); a++) {
            int d = arr[arr1[0]];
            for (int b = arr1[0]; b != arr1[1]; b+=s) {
                arr[b] = arr[b+s];
            }
            arr[arr1[1]] = d;
        }
        Print print = new Print();
        print.printValue("", message, arr);
    }
}
