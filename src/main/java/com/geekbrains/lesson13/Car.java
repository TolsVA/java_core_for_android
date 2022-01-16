package com.geekbrains.lesson13;

import static java.lang.System.currentTimeMillis;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private final Race race;
    private final int speed;
    private final String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race _race, int _speed){
        this.race = _race;
        this.speed = _speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run () {
        try {
            System.out.println(this.name + " готовится");
            MainClass.cd.await();
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            MainClass.cd.await();
            MainClass.cdStart.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        try {
            MainClass.lock.lock();
            if (MainClass.cdFinish.getCount() == (CARS_COUNT)) {
                System.out.printf("""
                        ----------------------------------------------------------------------------------------
                        Победитель гонки - %s - прошёл расстояние - %s метров за - %s  миллисекунд.
                        ----------------------------------------------------------------------------------------
                        """, this.getName(), this.race.getStages().get(0).length + this.race.getStages().get(1).length +
                        this.race.getStages().get(2).length, currentTimeMillis() - MainClass.time);
            } else {
                System.out.printf("""
                        --------------------------------------------------------------------------------------------------------
                        Участник гонки - %s - прошёл расстояние - %s метров за - %s  миллисекунд и занял - %s место.
                        --------------------------------------------------------------------------------------------------------
                        """, this.getName(), this.race.getStages().get(0).length + this.race.getStages().get(1).length +
                        this.race.getStages().get(2).length, currentTimeMillis() - MainClass.time, CARS_COUNT - MainClass.cdFinish.getCount() + 1);
            }
            MainClass.cdFinish.countDown();
        } finally {
            MainClass.lock.unlock();
        }
    }
}
