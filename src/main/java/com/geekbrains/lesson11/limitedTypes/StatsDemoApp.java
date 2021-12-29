package com.geekbrains.lesson11.limitedTypes;

public class StatsDemoApp {
    public static void main(String[] args) {
//        Stats<Integer> intStats = new Stats<>(1, 2, 3, 4, 5);
//        System.out.println("Ср. знач. intStats равно " + intStats.avg());
//        Stats<Double> doubleStats = new Stats<>(1.0, 2.0, 3.0, 4.0, 5.0);
//        Stats<Double> doubleStats1 = new Stats<>(1.0, 2.0, 3.0, 4.0, 5.0);
//        System.out.println("Ср. знач. doubleStats равно " + doubleStats.avg());
//        // Это не с компилируется, потому что String не является подклассом Number
//        //Stats<String> strStats = new Stats<>("1", "2", "3", "4", "5");
//        // System.out.println("Ср. знач. strStats равно " + strStats.avg());
//          if (doubleStats.sameAvg(doubleStats1)) {
//            System.out.println("Средние значения равны");
//          } else {
//            System.out.println("Средние значения не равны");
//          }
//          Stats<Integer> intStats1 = new Stats<>(1, 2, 3, 4, 5);
//          Stats<Integer> intStats2 = new Stats<>(2, 1, 3, 4, 5);
//          System.out.println(intStats1.sameAvg(intStats2));// Так работает
//          System.out.println(intStats1.sameAvg(doubleStats)); // Ошибка
////         (T = Integer) != (T = Double)

        Stats<Integer> iStats = new Stats<>(1, 2, 3, 4, 5); System.out.println("Среднее iStats = " + iStats.avg());
        Stats<Double> dStats = new Stats<>(1.1, 2.2, 3.3, 4.4, 5.5); System.out.println("Среднее dStats = " + dStats.avg());
        Stats<Float> fStats = new Stats<>(1.0f, 2.0f, 3.0f, 4.0f, 5.0f); System.out.println("Среднее fStats = " + fStats.avg());
        System.out.print("Средние iStats и dStats "); if (iStats.sameAvg(dStats)) {
            System.out.println("равны"); } else {
            System.out.println("отличаются"); }
        System.out.print("Средние iStats и fStats "); if (iStats.sameAvg(fStats)) {
            System.out.println("равны"); } else {
            System.out.println("отличаются");
        }
    }
}
