package com.geekbrains.lesson10_2;

import java.util.*;

public class Collection {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] arrNew = new int[10];
        System.arraycopy(arr, 0, arrNew, 0, arr.length);
        arr = arrNew;
        arrNew = null;
        System.out.println(Arrays.toString(arr));

        System.out.println();

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        System.out.println(arrayList);
        arrayList.add(1, "А0");
        System.out.println(arrayList);
        arrayList.remove("E");
        System.out.println(arrayList);
        arrayList.remove(2);
        System.out.println(arrayList);

        System.out.println();

        List<Integer> list = new ArrayList<>(); list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        Integer[] arr2 = new Integer[list.size()];
        list.toArray(arr2);
        System.out.println(Arrays.toString(arr2));

        System.out.println();

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("F");
        linkedList.add("B");
        linkedList.add("D");
        linkedList.add("Е");
        linkedList.add("C");
        System.out.println("1. linkedList: " + linkedList + " - Создан.");
        linkedList.addLast("Z");
        System.out.println("2. linkedList: " + linkedList + " - В конец добавлен элемент - Z.");
        linkedList.addFirst("A");
        System.out.println("3. linkedList: " + linkedList + " - В начало добавлен элемент - A.");
        linkedList.add(1, "А2");
        System.out.println("4. linkedList: " + linkedList + " - Добавлен элемент на вторую позицию по индексу 1 - A2.");
        linkedList.remove("F");
        System.out.println("5. linkedList: " + linkedList + " - Удалён элемент - F.");
        linkedList.remove(2);
        System.out.println("6. linkedList: " + linkedList + " - Удалён элемент по индексу - 2.");
        linkedList.removeFirst();
        System.out.println("7. linkedList: " + linkedList + " - Удалён элемент первый в списке.");
        linkedList.removeLast();
        System.out.println("8. linkedList: " + linkedList + " - Удалён элемент последний в списке.");
        String val = linkedList.peekFirst();
        System.out.println("9. String val = " + val + ": - присвоено значение полученного элемента первого в списке - linkedList.peekFirst();");
        val += linkedList.peekLast();
        System.out.println("10. String val = " + val + ": - к val добавлен полученный элемент последний в списке - val += linkedList.peekLast();");
        val += linkedList.get(2);
        System.out.println("11. String val = " + val + ": - к val добавлен полученный элемент по индексу 2 - val += linkedList.get(2);");
        linkedList.set(2, "(" + val + " изменено)");
        System.out.println("12. linkedList: " + linkedList + " - Изменена позиция по индексу 2 и присвоено значение (val +  изменено) - " +
                "linkedList.set(2, (val +  изменено)).");

        System.out.println();

        HashMap<String, String> hm = new HashMap<>();
        hm.put("Russia", "Moscow");
        hm.put("France", "Paris");
        hm.put("Germany", "Berlin");
        hm.put("Norway", "Oslo");
        for (Map.Entry<String, String> o : hm.entrySet()) {
            System.out.println(o.getKey() + ": " + o.getValue());
        }
        hm.put("Germany", "Berlin2");
        System.out.println("New Germany Entry: " + hm.get("Germany"));

        System.out.println();

        Set<String> set = new HashSet<>();
        set.add("Aльфa");
        set.add("Бета");
        set.add("Aльфa");
        set.add("Этa");
        set.add("Гaммa");
        set.add("Эпсилон");
        set.add("Oмeгa");
        set.add("Гaммa");
        System.out.println(set);

        System.out.println();

        Set<String> set1 = new LinkedHashSet<>();
        set1.add("Бета");
        set1.add("Aльфa");
        set1.add("Этa");
        set1.add("Гaммa");
        set1.add("Эпсилон");
        set1.add("Oмeгa");
        set1.add("Эпсилон");
        System.out.println(set1);

        System.out.println();

        Set<String> set2 = new TreeSet<>();
        set2.add("C");
        set2.add("A");
        set2.add("B");
        set2.add("E");
        set2.add("F");
        set2.add("D");
        set2.add("3");
        set2.add("2");
        set2.add("1");
        System.out.println(set2 + " Элементы автоматически располагаются в отсортированном порядке.");

        System.out.println();

        List<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C", "C", "A", "A",
                "B", "C", "B"));
        Iterator<String> iter = list1.iterator();
        while (iter.hasNext()) {
            String str = iter.next();
            if (str.equals("A")) {
                iter.remove();
            }
        }
        System.out.println(list1);

        ListIterator<String> iter2 = list1.listIterator();
        while (iter2.hasNext()) {
            String str = iter2.next();
            if (str.equals("A")) {
                iter2.remove();
            } else {
                iter2.set(str + "R");
                iter2.add("F" + str + "A");
            }
        }
        System.out.println(list1);

        System.out.println();

        List<Cat> cats = new ArrayList<>(Arrays.asList(
                new Cat("A", 5), new Cat("B", 2), new Cat("C", 4)
        ));
        System.out.println(cats);
        Collections.sort(cats);
        System.out.println(cats);
    }

}
