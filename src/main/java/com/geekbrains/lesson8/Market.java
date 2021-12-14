package com.geekbrains.lesson8;

import com.geekbrains.lesson8.person.Salesman;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private String name;
    private List<Salesman> salesmanList;


    public Market(String _name, int a) {
        setName(_name, a);
    }


    public void addSalesman(Salesman salesman){
        if(salesmanList == null){
            salesmanList = new ArrayList<>();
        }
        salesmanList.add(salesman);
    }

    public void setName(String name, int a) {
        this.name = name + " Собрал " + a;
    }

    public List<Salesman> getSalesmanList() {
        return salesmanList;
    }

    public void setSalesmanList(Salesman salesman) {
        addSalesman(salesman);
    }

    @Override
    public String toString() {
        return "===========================================================================================\n" +
                "                        " + name + " продавцов: \n" +
                "===========================================================================================\n" +
                salesmanList + "\n-------------------------------------------------------------------------------------------" +
                "\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^";
    }
}
