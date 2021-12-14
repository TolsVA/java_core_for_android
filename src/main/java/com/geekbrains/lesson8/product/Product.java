package com.geekbrains.lesson8.product;

public class Product {
    public static String[] lainProduct = new String[]{"Помидоры ", "Огурцы   ", "Морковь  ", "Капуста  ",
            "Картофель", "Свёкла   ", "Яйца     ", "Молоко   ", "Сметана  "};
    private String name;
    private int price;  // цена
    private int count;  // кол-во
    private int sold;  // Продано/Закуплено
    private int  proceeds;  // Выручка /Расходы
    private int remainder; // Остаток
    private String person;
    private String salesmanN;

    public Product(String _person, int i) {
        setPerson(_person);
        setName(lainProduct[i]);
        if (_person.equals("sal")) {
            setPrice(((int) (Math.random() * 9)) + 20);
            setCount(((int) (Math.random() * 9)) + 20);
            setSold(0);
            setProceeds(0);
        } else {
            setPrice(0);
            setCount(((int) (Math.random() * 9)) + 10);
            setPrice(0);
        }
        setRemainder(0);
    }

    public void setSalesmanN(String salesmanN) {
        this.salesmanN = salesmanN;
    }

    public int getRemainder() {
        return remainder;
    }

    public void setRemainder(int remainder) {
        this.remainder = getCount() - remainder;
    }

    public int getProceeds() {
        return proceeds;
    }

    public void setProceeds(int proceeds) {
        this.proceeds = getPrice() * proceeds;
    }

    public void setSold(int sold) {
        this.sold = sold;
        setRemainder(this.sold);
        setProceeds(this.sold);
    }

    public Product clone(String person, int i) {
        return new Product(person, i);
    }

    @Override
    public String toString() {
        String text;
        if (this.getPerson().equals("sal")) {
            text = " " + name +
                    ",   Цена = " + price +
                    ",   Начальное кол-во = " + count +
                    ",   Продано  = " + sold +
                    ",   Остаток  = " + remainder +
                    ",   Выручка  = " + proceeds + "\n\t\t\t  ";
            return text;
        } else if (this.getPerson().equals("cus")){
            text = " " + name +
                    ", \tНачальное кол-во = " + count +
                    ", \tЦена = " + price +
                    ", \tЗакуплено  = " + sold +
                    ", \tОстаток  = " + remainder +
                    ", \tРасходы  = " + proceeds +
                    ", \t" + salesmanN + "\n\t\t\t  ";
            return text;
        } else {
            text = " " + name +
                    ",\tЦена = \"Неизвестна\"" +
                    ",\tНачальное кол-во = " + count +
                    ",\tЗакуплено  = " + sold +
                    ",\tОстаток  = " + remainder +
                    ",\tРасходы  = " + proceeds + "\n\t\t\t  ";
            return text;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        setProceeds(this.sold);
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

}
