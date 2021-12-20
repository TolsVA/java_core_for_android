package com.geekbrains.lesson8;

import com.geekbrains.lesson8.person.Salesman;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private List<Salesman> salesmanList;

    public Market() {
    }

    public void addSalesman(Salesman salesman){
        if(salesmanList == null){
            salesmanList = new ArrayList<>();
        }
        salesmanList.add(salesman);
    }

    public List<Salesman> getSalesmanList() {
        return salesmanList;
    }

    public void setSalesmanList(Salesman salesman) {
        addSalesman(salesman);
    }

    @Override
    public String toString() {
        return salesmanList + "\n-------------------------------------------------------------------------------------------" +
                "\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^";
    }
}
