package com.geekbrains.lesson3;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Homework3 {
    public static Scanner in = new Scanner(System.in);
    public static Scanner sn = new Scanner(System.in);

    public abstract boolean equals(Object o);

    public static void main(String[] args) {

        System.out.println("При запуске этой програмы произошла неизвестная ошибка!!! " +
                "\nВаш компютер устал и хочет поиграть. Вы с ним поиграете? \n1 - Да       2 - Нет");
        int x;
        x = ifTheString();
        if (x == 1) {
            headMenu(x);
        } else if (x == 2) {
            gameOver();
            return;
        }
    }

    private static void gameOver() {
        System.out.println("GAME OVER     GAME OVER     GAME OVER     GAME OVER     GAME OVER");
        return;
    }

    public static int getNumberFromScanner(String message, int min, int max) {
        int x;
        do {
            x = in.nextInt();
            if (x == 1 || x == 2 || x == 3) {
                return x;
            }
            System.out.println(message);

        } while (x < min || x > max);
        return x;
    }

    public static void headMenu(int a) {
        System.out.println("Вы вошли в главное меню игровой площядки. " +
                "\nВыберите игру в которую будете играть. " +
                "\n1 - Угадай число     2 - Угадай слово. 3 - Не хочу играть.");
        a = ifTheString();
        if (a == 1) {
            guessTheNumber();
            return;
        } else  if (a == 2) {
            word();
            return;
        } else if (a == 3){
            gameOver();
            return;
        }
        return;
    }

    public static int ifTheString() {
        int x;
        while (true) {
            try {
                x = getNumberFromScanner("Вы ввели символы не влияюшие на ход " +
                        "выполнения программы :(.", 1, 3);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели стоку");
                in.next();
            }
        }
        return x;
    }
    public static int ifTheString1() {
        int x;
        while (true) {
            try {
                x = in.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели стоку");
                in.next();
            }
        }
        return x;
    }

    public static void guessTheNumber() {
        System.out.println("Введите диапазон игры от 0 и до .......");
        int f = ifTheString1();
        int a = (int) Math.round((Math.random() * f));
        System.out.println("Машина случайным образом загадала число от 0 до " + f + ".\nУ тебя 3 попытки. Попробуй угадать.");
        int n = 3;
        for (int i = 0; i < 3; i++, --n) {
            int b = ifTheString1();
            if (a == b) {
                System.out.println("Вы выиграли! Сыграем ещё? \n1 – повторить       2 – нет");
                if (ifTheString() == 1) {
                    guessTheNumber();
                } else {
                    headMenu(a);
                }
                return;
            } else if (a > b) {
                if (n - 1 == 0) {
                    System.out.println("Вы проиграли. Загаданное число было - " + a + ". Попытаетесь ещё?" +
                            " \n1 – повторить       2 – нет");
                    if (ifTheString() == 1) {
                        guessTheNumber();
                    } else {
                        headMenu(a);
                    }
                    return;
                } else {
                    System.out.println("Загаданное число больше. Осталось попыток - " + (n - 1));
                }
            } else if (a < b) {
                if (n - 1 == 0) {
                    System.out.println("Вы проиграли. Загаданное число было - " + a + ". Попытаетесь ещё? " +
                            "\n1 – повторить       2 – нет");
                    if (ifTheString() == 1) {
                        guessTheNumber();
                    } else {
                        headMenu(a);
                    }
                    return;
                } else {
                    System.out.println("Загаданное число меньше. Осталось попыток - " + (n - 1));
                }
            }
        }
    }

    public static void word() {
        String[] words = new String[]{"яблоко", "апельсин", "лимон", "банан", "абрикос", "авокадо", "" +
                "брокколи", "морковь", "вишня", "чеснок", "виноград", "дыня", "течь", "киви", "манго", "" +
                "гриб ", "орех", "оливка", "горох", "арахис", "груша", "перец", "ананас", "тыква" +
                "", "картофель"};
        int a = (int) Math.round(Math.random() * words.length-1);
        String str = words[a];
        System.out.println("Машина случайным образом загадала слово.");
        System.out.println("Угадать слово целиком - 1.  Угадывать по буквам - 2");
        int x = ifTheString();
        if (x == 1) {
            wholeWord(str, a);
            return;
        } else if (x == 2){
            letters(str);
            return;
        }
    }

    public static void wholeWord(String str, int a) {
        System.out.println("У Вас есть 2 подсказки: Угадать сразу - 1. Или воспользоваться подсказкой - 2");
        int x = ifTheString();
        if (x == 1) {
            System.out.println("Загаданное слово состоит из - " + str.length() + " букв. " +
                    "Первая буква " + str.charAt(0) + ", Введите слово целиком..." + str);
            String r = in.nextLine();
            if (in.nextLine().equals(str)) {
                System.out.println("Вы выиграли!!! Слово действительно - " + str + "\nХотите ещё сыграть? " +
                        "\n1 – повторить       2 – нет");
                x = ifTheString();
                if (x == 1) {
                    word();
                } else if (x == 2) {
                    headMenu(x);
                }
            } else {
                System.out.println("Вы проиграли. Загаданное слово - " + str + "\nХотите ещё сыграть? " +
                        "\n1 – повторить       2 – нет");
                x = ifTheString();
                if (x == 1) {
                    word();
                } else if (x == 2) {
                    headMenu(x);
                }
            }
        } else if (x == 2){
            open(str);
        }
    }

    public static void open(String str) {
        System.out.println("В слове - " + str.length() + " букв. Какую букву открыть? " +
                "\n(Введите порядковый номер буквы которую хотите открыть.)");
        String[] args1 = new String[str.length()];
        int f = 2;
        while (String.join("", args1).equals(str) == false) {
            if (f >= 0) {
                int s = ifTheString1();
                if (s <= str.length()) {
                    for (int i = 0; i < str.length(); i++) {
                        for (i = 0; i < str.length(); i++) {
                            if (i == 0) {
                                args1[i] = String.valueOf(str.charAt(i));
                                System.out.print(args1[i] + " ");
                            } else if (i == s - 1) {
                                args1[i] = String.valueOf(str.charAt(i));
                                System.out.print(args1[i] + " ");
                            } else if (i != s - 1) {
                                if (args1[i] == null) {
                                    args1[i] = "*";
                                    System.out.print(args1[i] + " ");
                                } else {
                                    System.out.print(args1[i] + " ");
                                }
                            }
                        }
                    }
                    f--;
                    if (f == 1) {
                        System.out.println("\nУ Вас осталась одна подсказка");
                    } else if (f == 0) {
                        System.out.println("\nУ Вас больше нет подсказок. Введите слово целиком.\nУДАЧИ ВИТАЛЯ :))");
                        String r = in.nextLine();
                        if (in.nextLine().equals(str)) {
                            System.out.println("Вы выиграли!!! Слово действительно - " + str + "\nХотите ещё сыграть? " +
                                    "\n1 – повторить       2 – нет");
                            int x = ifTheString();
                            if (x == 1) {
                                word();
                            } else if (x == 2) {
                                headMenu(x);
                            }

                        } else {
                            System.out.println("Вы проиграли. Загаданное слово - " + str + "\nХотите ещё сыграть? " +
                                    "\n1 – повторить       2 – нет");
                            int x = ifTheString();
                            if (x == 1) {
                                word();
                            } else if (x == 2) {
                                headMenu(x);
                            }
                        }
                        int x = ifTheString();
                        if (x == 1) {
                            word();
                        } else if (x == 2) {
                            headMenu(x);
                        }
                    }
                } else {
                    System.out.println("В этом слове всего " + str.length() + " букв.");
                }
            }
        }
    }
    public static void letters(String str) {
        int i;
        String[] args1 = new String[str.length()];
        System.out.println("Загаданное слово состоит из - " + str.length() + " букв. " +
                "Первая буква " + str.charAt(0) + ". У Вас 2 шанса на неправильный ответ. Введите букву _.  PS: " + str);
        int s = 2;
        while (String.join("", args1).equals(str) == false)  {
            if (s >= 0){
                String x = sn.nextLine();
                char char1 = x.charAt(0);
                if (str.contains(x)) {
                    for (i = 0; i < str.length(); i++) {
                        if (i == 0) {
                            args1[i] = String.valueOf(str.charAt(i));
                            System.out.print(args1[i] + " ");
                        } else if (char1 == str.charAt(i)) {
                            args1[i] = String.valueOf(str.charAt(i));
                            System.out.print(args1[i] + " ");
                        } else if (char1 != str.charAt(i)) {
                            if (args1[i] == null ) {
                                args1[i] = "*";
                                System.out.print(args1[i] + " ");
                            } else {
                                System.out.print(args1[i] + " ");
                            }
                        }
                    }
                    if (String.join("", args1).equals(str) != true) {
                        System.out.println("\nВ этом слове есть такая буква. Введите следующую _.");
                    }
                } else {
                    System.out.println("Такой буквы нет.");
                    s = s - 1;
                    if (s > 0) {
                        System.out.println("Шансов на ошибку осталось - " + s);
                    } else if (s == 0){
                        System.out.println("Шансов на ошибку больше нет.");
                    } else if (s == -1) {
                        System.out.println("Вы проиграли. Загаданное слово - " + str + "\nХотите ещё сыграть? " +
                                "\n1 – повторить       2 – нет");
                        int z = ifTheString();
                        if (z == 1) {
                            word();
                            return;
                        } else if (z == 2) {
                            headMenu(z);
                            return;
                        }
                    }
                }
            }
            if (String.join("", args1).equals(str) == true) {
                System.out.println("\nДа!!! Вы выиграли. Это слово " + str + ".\nХотите повторить 1 - Да  2 - Нет.");
                int z = ifTheString();
                if (z == 1) {
                    word();
                    return;
                } else if (z == 2) {
                    headMenu(z);
                    return;
                }
            }
        }
    }
}
