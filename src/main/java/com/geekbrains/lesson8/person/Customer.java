package com.geekbrains.lesson8.person;

import com.geekbrains.lesson8.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    private final String nameCustomer;
    List<Product> purchaseList;
    List<Product> expectedPurchaseList;

    public Customer() {
        this.nameCustomer = "ИВАНОВ ИВАН ИВАНЫЧ.";
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public List<Product> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(Product product) {
        if(purchaseList == null){
            purchaseList = new ArrayList<>();
        }
        purchaseList.add(product);
    }

    @Override
    public String toString() {
        if (expectedPurchaseList == null) {
            return "\t\t\t   " + purchaseList;
        } else {
            return "\t\t\t   " + expectedPurchaseList;
        }
    }

    public List<Product> getExpectedPurchaseList() {
        return expectedPurchaseList;
    }

    public void setExpectedPurchaseList(Product product) {
        if(this.expectedPurchaseList == null){
            this.expectedPurchaseList = new ArrayList<>();
        }
        this.expectedPurchaseList.add(product);
    }
}
