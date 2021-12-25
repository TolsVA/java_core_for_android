package com.geekbrains.lesson10;

import java.util.*;

public class Homework10 {
    public static void main(String[] args) {
        String[] fruit = new String[] {"Яблоко  ", "Киви\t", "Апельсин", "Яблоко  ", "Мандарин", "Банан   ", "Киви\t",
                "Банан   ", "Яблоко  ", "Киви\t", "Яблоко  ", "Мандарин", "Мандарин", "Яблоко  ", "Мандарин"};

        List<String> listFruit = new ArrayList<>(Arrays.asList(fruit));

        Set<String> set = new TreeSet<>(listFruit);         // Убрал лишнее чтобы цикл сократить.
                                                            // Так мне кажется для больших массивов быстрее будет.
        System.out.println("\n" + listFruit + "\n");
        System.out.println(set + "\n");
        treeMap(listFruit, set);
        System.out.println();

        Phonebook phonebook = new Phonebook();
        for (int i = 0; i < 50; i++) {
            phonebook.setPhonebooks(new Contact());
        }
        System.out.print(phonebook);
        System.out.println("\n");
        String surname = "Иванов";
        sort(phonebook, surname);
    }

    private static void sort(Phonebook phonebook, String _surname) {
        LinkedList<String> ph = new LinkedList<>();

        TreeMap<String, String> treeMap = new TreeMap<>();
        for (int i = 0; i < phonebook.getPhonebooks().size(); i++){
            int s = 1;
            StringBuilder tel = new StringBuilder("тел: " + phonebook.getPhonebooks().get(i).getPhone());
            if(phonebook.getPhonebooks().get(i).getSurname().equals(_surname)){
                ph.add("\n" + phonebook.getPhonebooks().get(i).getSurname() + " " +
                        phonebook.getPhonebooks().get(i).getName() + " \t тел: " +
                        phonebook.getPhonebooks().get(i).getPhone());
                for (int j = 0; j < phonebook.getPhonebooks().size(); j++) {
                    if (phonebook.getPhonebooks().get(i).getSurname().equals(phonebook.getPhonebooks().get(j).getSurname()) &&
                            phonebook.getPhonebooks().get(i).getName().equals(phonebook.getPhonebooks().get(j).getName())) {
                        if (i != j) {
                            s++;
                            tel.append("\n\t\t\t\t\t\t\t\tтел: ").append(phonebook.getPhonebooks().get(j).getPhone());
                        }
                    }
                }
                if (s == 1) {
                    treeMap.put(phonebook.getPhonebooks().get(i).getSurname() + " " +
                            phonebook.getPhonebooks().get(i).getName()+ " \tсовпадений(0)", tel + "\n" +
                            "-----------------------------------------------------");
                } else {
                    treeMap.put(phonebook.getPhonebooks().get(i).getSurname() + " " +
                            phonebook.getPhonebooks().get(i).getName() + " \tсовпадений(" + s + ")", tel + "\n" +
                            "-----------------------------------------------------");
                }

            }

        }

        System.out.printf("""
                ----------------------------------------------
                Список контактов по фамилии - %s
                ----------------------------------------------""", _surname);
        System.out.println(ph);
        System.out.println();
        System.out.println("""
                =====================================================
                Отсортированы совпадения по имени и фамилии:
                =====================================================""");
        for (Map.Entry<String, String> o : treeMap.entrySet()) {
            System.out.println(o.getKey() + ":  " + o.getValue());
        }
    }


    private static void treeMap(List<String> listFruit, Set<String> set) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        int y;
        for (String s : set){
            y = 0;
            for (String value : listFruit) {
                if (Objects.equals(s, value)) {
                    y++;
                }
            }
            treeMap.put(s, String.valueOf(y));
        }
        for (Map.Entry<String, String> o : treeMap.entrySet()) {
            System.out.println(o.getKey() + ": - " + o.getValue() + " (повторений)");
        }
    }
}
