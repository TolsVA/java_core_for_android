package com.geekbrains.lesson7.Human;

public class Admin extends Human {
    private int purse;                //Кошелёк
    private  int ticketSelling;       // Продажа билетов
    private  int tickets;             //Билеты
    private int rubles = 1000;                 //Билеты

    public Admin() {

    }

    @Override
    public String getPosition() {
        position = "Администратор";
        return position;
    }

    @Override
    public String getSurname() {
        surname = "Иванов";
        return surname;
    }

    @Override
    public String getName() {
        name = "Иван";
        return name;
    }

    @Override
    public String getPatronymic() {
        patronymic = "Иваныч";
        return patronymic;
    }

    @Override
    public int getAge() {
        age = 35;
        return age;
    }
    @Override
    public int getRubles() {
        return rubles;
    }

    public void setRublesPay(int rubles) {
        this.rubles = this.rubles - rubles;
    }

    public void setRublesProfit(int rubles) {
        this.rubles = this.rubles + rubles;
    }

}
