package com.geekbrains.lesson10;

public class Contact extends Phonebook {
    private String name;
    private String surname;
    private String phone;
    public String lainName = "Иван, Филипп, Василий, Юрий, Антон";
    public String lainSurname = "Иванов, Петров, Сидоров, Васечкин, Митичкин";

    Contact(){
        this.name = lainName.split(", ")[(int) Math.round(Math.random() * (lainName.split(", ").length - 1))];
        this.surname = lainSurname.split(", ")[(int) Math.round(Math.random() * (lainSurname.split(", ").length - 1))];
        this.phone = ("+7 " + ((int) (Math.random() * (999 - 900)) + 900) + "-" + ((int) (Math.random() * (999 - 100)) + 100) + "-" +
                (((int) (Math.random() * 89)) + 10) + "-" + (((int) (Math.random() * 89)) + 10));
    }

    @Override
    public String toString() {
        return "\n" + surname + " " +
                " \t" + name +
                "\t\tтел: " + phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
