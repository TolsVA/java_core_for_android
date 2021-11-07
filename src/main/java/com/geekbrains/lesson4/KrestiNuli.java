package com.geekbrains.lesson4;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public abstract class KrestiNuli {
    private static int COLUMN;
    private static int ROW;
    private static int n;
    private static int m;
    private static char DOT_EMPTY = '•';
    private static char DOT_X;
    private static char DOT_O;
    private static char[][] map;
    private static Random rand = new Random();
    public static Scanner se = new Scanner(System.in);
    public static Scanner in = new Scanner(System.in);
    private static final String lain = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        System.out.println("""
                Вы вошли в игру крестики нолики.
                Выберите фигуру которой будете играть.
                X - введите 1 / O - введите 2.""");
        choiceView();
        System.out.println("""
                Введите размер игрового поля.
                По диагонали столбцы / По вертикали строки в формате - 10/10
                (PS: Столбцов (диогональ) не может быть больше 26)""");
        int result[] = fieldSize();
        COLUMN = result[0];
        ROW = result[1];
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if(checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if(isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if(checkWin(DOT_O)) {
                System.out.println("Победил Компьютер");
                break;
            }
            if(isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("""
                Игра окончена.
                PS: Хотелось бы более подробно получить отзывы и рекомендации о проделанной работе""");
    }
    public static int getNumberFromScanner(String message, int min, int max) {
        int x;
        do {
            x = se.nextInt();
            if (x == 1 || x == 2) {
                return x;
            }
            System.out.println(message);
        } while (x < min || x > max);
        return x;
    }
    public static void choiceView() {
        int x;
        while (true) {
            try {
                x = getNumberFromScanner("Вы ввели символы не влияюшие на ход " +
                        "выполнения программы :(.", 1, 2);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели стоку");
                se.next();
            }
        }
        if (x == 1) {
            DOT_X = 'X';
            DOT_O = 'O';
        }
        if (x == 2) {
            DOT_X = 'O';
            DOT_O = 'X';
        }
        System.out.printf("Вы будите играть - %s Компьютер - %s\n",DOT_X,DOT_O);
    }
    private static int[] fieldSize() {
        String[] inputs = new String[2];
        int x;
        int y;
        do {
            while (true) {
                try {
                    inputs = in.nextLine().split("/");
                    x = Integer.parseInt(inputs[0]);
                    y = Integer.parseInt(inputs[1]);
                    return new int[] {x, y};
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("""
                            Границы выходят за пределы допустимого диапазона.
                            Введите размер игрового поля.
                            По диагонали столбцы / По вертикали строки в формате - 10/10
                            (PS: Столбцов (диогональ) не может быть больше 26)""");
                }
            }
        }while (!isCellValid1(x, y));
    }

    private static void aiTurn() {
        int x;
        int y;
        int result[] = checkWin1();
        if (result[0] >= 0 && result[1] >= 0) {
            x = result[0];
            y = result[1];
        } else {
            do {
                x = rand.nextInt(COLUMN);
                y = rand.nextInt(ROW);
            } while (!isCellValid(x, y));
        }
        System.out.println("Компьютер сходил в точку " + (lain.charAt(x)) + "/" + (y + 1));
        map[x][y] = DOT_O;
    }

    private static void initMap() {
        map = new char[COLUMN][ROW];
        for (int i = 0; i < COLUMN; i++) {
            for (int j = 0; j < ROW; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static boolean isMapFull() {
        for (int i = 0; i < COLUMN; i++) {
            for (int j = 0; j < ROW; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printMap() {
        System.out.println();
        for (int j = ROW-1; j >= 0; j--) {
            System.out.print((j + 1) + "\t");
            for (int i = 0; i < COLUMN; i++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < COLUMN; i++) {
            if (i == 0) {
                System.out.print("\t");
            }
            System.out.print(lain.charAt(i) + " ");
        }
        System.out.println();
    }

    private static void humanTurn() {
        int row;
        int column;
        int x;
        do {
            System.out.println("Введите координаты в формате e/4");
            String[] inp = in.nextLine().split("/");
            x = lain.indexOf(inp[0]);
            column = x;
            row = Integer.parseInt(inp[1]) - 1;
        } while (!isCellValid(column, row));
        map[column][row] = DOT_X;
        System.out.println();
    }
    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= COLUMN || y < 0 || y >= ROW) {
            System.out.println("Ваши координаты выходят за пределы границ игрового поля.");
            return false;
        }
        if (map[x][y] == DOT_EMPTY) {
            return true;
        } else if (map[x][y] == DOT_X) {
            return false;
        } else if (map[x][y] == DOT_O) {
            System.out.println("Это игровое поле занято компьютером.");
            return false;
        }
        return false;
    }

    private static boolean isCellValid1(int x, int y) {
        if (x < 3 || x > 26 || y < 3) {
            System.out.println("Столбцы и строки не могут быть меньше 3. \n(PS: Столбцов (диогональ) не может быть больше 26)");
            return false;
        } else {
            return true;
        }
    }
    private static boolean checkWin(char symbol) {
        int i, j, x, s, r, q, p, l, k;
        int f = 0;
        int t = 0;
        q = Math.min(COLUMN, ROW);
        if (q > 4) {
            p = 4;
        } else {
            p = 3;
        }
        for (j = 0; j < ROW; j++) {
            k = 0;
            for (i = 0; i < COLUMN; i++) {
                if (map[i][j] == symbol) {
                    k++;
                }
                if (k == COLUMN) {
                    return true;
                }
            }
        }
        for (x = -(COLUMN - 1) ; x <= (ROW - 1); x++) {
            s = 0;
            r = 0;
            for (i = 0; i < COLUMN; i++) {
                l = 0;
                for (j = 0; j < ROW; j++) {
                    if (map[i][j] == symbol) {
                        l++;
                    }
                    if (l == ROW) {
                        return true;
                    }
                    if (i == j - x) {
                        if (map[i][j] == symbol) {
                            s++;
                            if (s == 1) {
                                f = diagonalSize(i, j, q);
                            }
                            if (s == f && s >= p) {
                                return true;
                            }
                        }
                    }
                    if (i == (ROW-1)-j-x) {
                        if (map[i][j] == symbol) {
                            r++;
                            if (r == 1) {
                                t = diagonalSize1(i, j, q);
                            }
                            if (r == t && r >= p) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private static int[] checkWin1() {
        int i, j, x, s, r, q, p, k, t, e, y, w, u, o, l, h;
        int f = 0;
        int z = 0;
        q = Math.min(COLUMN, ROW);
        if (q > 4) {
            p = 4;
        } else {
            p = 3;
        }
        for (j = 0; j < ROW; j++) {
            k = 0;
            t = 0;
            r = -1;
            for (i = 0; i < COLUMN; i++) {
                if (map[i][j] == DOT_X) {
                    k++;
                }
                if (map[i][j] == DOT_EMPTY) {
                    t++;
                    r = i;
                }
                if (k == COLUMN - 1 && t == 1) {
                    System.out.println("Компьютер вычислил Ваш следующий ход");
                    return new int[] {r, j};
                }
            }
        }
        for (x = -(COLUMN - 1) ; x <= (ROW - 1); x++) {
            s = 0;
            e = -1;
            y = -1;
            w = 0;
            h = 0;
            u = -1;
            o = -1;
            l = 0;
            for (i = 0; i < COLUMN; i++) {
                k = 0;
                t = 0;
                r = -1;
                for (j = 0; j < ROW; j++) {

                    if (map[i][j] == DOT_X) {
                        k++;
                    }
                    if (map[i][j] == DOT_EMPTY) {
                        t++;
                        r = j;
                    }
                    if (k == ROW - 1 && t == 1) {
                        System.out.println("Компьютер вычислил Ваш следующий ход");
                        return new int[] {i, r};
                    }
                    if (i == j - x) {

                        if (map[i][j] == DOT_X) {
                            s++;
                            if (s == 1) {
                                f = diagonalSize(i, j, q);
                            }
                        }
                        if (map[i][j] == DOT_EMPTY) {
                            w++;
                            e = i;
                            y = j;
                        }
                        if (s == (f - 1) && s >= (p - 1) && w == 1) {
                            System.out.println("Компьютер вычислил Ваш следующий ход.");
                            return new int[] {e, y};
                        }
                    }
                    if (i == (ROW-1)-j-x) {
                        if (map[i][j] == DOT_X) {
                            h++;
                            if (h == 1) {
                                z = diagonalSize1(i, j, q);
                            }
                        }
                        if (map[i][j] == DOT_EMPTY) {
                            l++;
                            u = i;
                            o = j;
                        }
                        if (h == (z - 1) && h >= (p - 1) && l == 1) {
                            System.out.println("Компьютер вычислил Ваш следующий ход.");
                            return new int[] {u, o};
                        }
                    }
                }
            }
        }
        return new int[] {-1, -1};
    }

    private static int diagonalSize(int i, int j, int q) {
        int f = 0;
        if (COLUMN == ROW) {
            f = (COLUMN - i - j) - (COLUMN - ROW);
        }
        if (COLUMN < ROW) {
            if (j > 0 || ((ROW - j) < q)) {
                f = q;
            }
            if (j >= ROW - COLUMN) {
                f = ROW - j;
            }
            if (j == 0){
                f = (COLUMN - i);
            }
        }
        if (COLUMN > ROW) {
            if (COLUMN - i + j < ROW) {
                f = COLUMN - i + j;
            } else if (i >= 1){
                f = ROW;
            } else  if (i == 0) {
                f = (ROW - j);
            }
        }
        if (f > q) {
            f = q;
        }
        return f;
    }

    private static int diagonalSize1(int i, int j, int q) {
        int t;
        if (COLUMN <= ROW) {
            if (j < q - 1) {
                t = j +1;
            } else {
                t = (COLUMN - i) - (ROW - j) + (ROW - j);
            }
        } else {
            if ((COLUMN - i) > q) {
                if (i > 0 || j == ROW - 1) {
                    t = q;
                } else {
                    t = j + 1;
                }
            } else t = (COLUMN - i);
        }
        if (t > q) {
            t = q;
        }
        return t;
    }
}
