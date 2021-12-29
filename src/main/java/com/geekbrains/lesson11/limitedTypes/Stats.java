package com.geekbrains.lesson11.limitedTypes;

public class Stats<T extends Number> {
    private T[] nums;

    @SafeVarargs    public Stats(T... nums) {
        this.nums = nums;
    }

    public double avg() {
        System.out.println(nums.getClass().getName());
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            // У nums[i] появился метод doubleValue() из класса Number
            // который позволяет любой числовой объект привести к double
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    public boolean sameAvg(Stats<?> another) {
        System.out.println("Сравниваются любые типы числовых данных");
        return Math.abs(this.avg() - another.avg()) < 0.0001;
    }

//     public boolean sameAvg(Stats<T> another) {
//         System.out.println("Сравниваются только одинаковые типы числовых данных");
//        return Math.abs(this.avg() - another.avg()) < 0.0001;
//     }

//    public boolean sameAvg(Stats<Double> doubleStats) {
//        System.out.println("Сравниваются разные типы числовых данных с Double");
//        return Math.abs(this.avg() - doubleStats.avg()) < 0.0001;
//    }
}
