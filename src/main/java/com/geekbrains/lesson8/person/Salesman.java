package com.geekbrains.lesson8.person;

import com.geekbrains.lesson8.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Salesman extends Person {
    private static int z = 0;
    private final String nameSalesman;
    private List<Product> productList;

    public Salesman() {
        this.nameSalesman = String.format("Продавец - %03d ", z);

    }

    public Salesman clone(int i) {
        z = i;
        return new Salesman();
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public String toString() {
        return   "\n-------------------------------------------------------------------------------------------\n" +
                nameSalesman + productList;
    }

    public String getNameSalesman() {
        return nameSalesman;
    }

    public void setProductList(Product product) {
        if(productList == null){
            productList = new ArrayList<>();
        }
        productList.add(product);
    }
}
