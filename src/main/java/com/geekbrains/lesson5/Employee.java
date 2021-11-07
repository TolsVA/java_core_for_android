package com.geekbrains.lesson5;

public class Employee {
    private int personnel;        // Табельный номер
    private String surname;       // Фамилия
    private String firstName;     // Имя
    private String patronymic;    // Отчество
    private String position;      // Должность
    private String email;         // email
    private String phone;         // Телефон
    private int salary;           // Зарплата
    private int age;              // Возраст


    public Employee(int _personnel, String _surname, String _firstName, String _patronymic, String _position,
                    String _email, String _phone, int _salary, int _age) {
        this.personnel = _personnel;
        this.surname = _surname;
        this.firstName = _firstName;
        this.patronymic = _patronymic;
        this.position = _position;
        this.email = _email;
        this.phone = _phone;
        this.salary = _salary;
        this.age = _age;
    }

    public Employee clone(int i){
        Employee employee = new Employee();
        employee.personnel = i + 1;
        employee.surname = Homework5.lainSurname.split(", ")[(int) Math.round(Math.random() * (Homework5.lainSurname.split(", ").length - 1))];
        employee.firstName = Homework5.lainFirstName.split(", ")[(int) Math.round(Math.random() * (Homework5.lainFirstName.split(", ").length - 1))];
        employee.patronymic = Homework5.lainPatronymic.split(", ")[(int) Math.round(Math.random() * (Homework5.lainPatronymic.split(", ").length - 1))];
        employee.position = Homework5.lainPosition.split(", ")[(int) Math.round(Math.random() * (Homework5.lainPosition.split(", ").length - 1))];
        employee.email = ((int) (Math.random() * (100000 - 10000)) + 10000) + "@mail.ru";
        employee.phone = "+7 " + ((int) (Math.random() * (999 - 900)) + 900) + "-" + ((int) (Math.random() * (999 - 100)) + 100) + "-" +
                (((int) (Math.random() * 89)) + 10) + "-" + (((int) (Math.random() * 89)) + 10);
        employee.salary = (((int) (Math.random() * 13)) * 10000) + 20000;
        employee.age = (int) (Math.random() * (65 - 20) + 20);
        return employee;
    }

    public Employee() {

    }

    public void print(Employee employee) {
        System.out.printf("""
                        Сотрудник:
                        Таб. №:\t\t- %04d
                        Фамилия:\t- %s
                        Имя:\t\t- %s
                        Отчество:\t- %s
                        Должность:\t- %s
                        email:\t\t- %s
                        Телефон:\t- %s
                        Зарплата:\t- %s рублей.
                        Возраст:\t- %s лет.""",
                employee.getPersonnel(), employee.getSurname(), employee.getFirstName(), employee.getPatronymic(), employee.getPosition(),
                employee.getEmail(), employee.getPhone(),employee.getSalary(), employee.getAge());
        System.out.println("\n--------------------------------------");
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {this.salary = salary;}

    public int getAge() {return age;}

    public void setAge(int age) {
        if(age < 0) {
            System.out.println("Невозможно присвоить возраст меньше 0");
        } else {
            this.age = age;
        }
    }

    public int getPersonnel() {
        return personnel;
    }

    public void setPersonnel(int personnel) {
        this.personnel = personnel;
    }

}
