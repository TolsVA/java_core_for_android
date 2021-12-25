package com.geekbrains.lesson10;

import java.util.LinkedList;

public class Phonebook {
    private String name;
    private String surname;
    private String phone;

    private LinkedList<Phonebook> phonebooks;

    Phonebook(){
    }

    @Override
    public String toString() {
        return """
                ----------------------------------------------
                         <<< Телефонный Справочник >>>
                ----------------------------------------------""" + phonebooks;
    }

    public LinkedList<Phonebook> getPhonebooks() {
        return phonebooks;
    }

    public void setPhonebooks(Contact contact) {
        if(this.phonebooks == null){
            this.phonebooks = new LinkedList<>();
        }
        this.phonebooks.add(contact);
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
