package com.geekbrains.lesson8;

import com.geekbrains.lesson8.person.Customer;
import com.geekbrains.lesson8.person.Salesman;
import com.geekbrains.lesson8.product.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        String mark = "ПРОДОВОЛЬСТВЕННЫЙ РЫНОК";
        System.out.printf("""
                %s объявил о наборе участников рынка
                <<<< Введите количество продавцов. >>>>"""
                ,mark);
        int a = numberOfAthletes();

        Market market = new Market();

        String sal = "sal";
        String cus = "cus";
        String exp = "exp";

        Salesman salesman = new Salesman();
        Salesman[] arrSalesmen = new Salesman[a];
        Product product = new Product(sal,(int) (Math.random() * 9));
        Product[] arrProduct = new Product[4];

        Customer customer = new Customer();
        Product[] arrPurchaseList = new Product[6];

        int r;
        for (int i = 0; i < a; i++) {
            arrSalesmen[i] = salesman.clone(i + 1);
            market.setSalesmanList(arrSalesmen[i]);
            for (int j = 0; j < 4; j++) {
                r = (int) (Math.random() * 9);
                if (j == 0) {
                    arrProduct[j] = product.clone(sal, r);
                    arrSalesmen[i].setProductList(arrProduct[j]);
                } else {
                    selection(j, arrProduct, product, sal, r, arrSalesmen, i, customer);
                }
            }
        }

        int f;
        for (int j = 0; j < 6; j++) {
            f = (int) (Math.random() * 9);
            if (j == 0) {
                arrPurchaseList[j] = product.clone(cus, f);
                customer.setPurchaseList(arrPurchaseList[j]);
            } else {
                selection(j, arrPurchaseList, product, cus, f, arrSalesmen, 0, customer);
            }
        }
        System.out.println("===========================================================================================\n" +
                "                        \""+ mark +"\"" + " СОБРАЛ: " + a + " ПРОДАВЦОВ.\n" +
                "===========================================================================================");
        System.out.println(market);
        System.out.println("        СПИСОК ПРЕДПОЛАГАЕМЫХ ПОКУПОК СЛУЧАЙНОГО ПОКУПАТЕЛЯ " + customer.getNameCustomer());
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println(customer);
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");


        // Проверяем по всем продавцам товар по наличию и ценам.
        int x = 0;
        int y = 0;
        for (int i = 0; i < customer.getPurchaseList().toArray().length; i++) {
            do {
                int k = 99999;
                for (int j = 0; j < market.getSalesmanList().toArray().length; j++) {
                    for (int l = 0; l < market.getSalesmanList().get(j).getProductList().toArray().length; l++) {
                        if (customer.getPurchaseList().get(i).getName().
                                equals(market.getSalesmanList().get(j).getProductList().get(l).getName()) &&
                                market.getSalesmanList().get(j).getProductList().get(l).getRemainder() > 0) {

                            // Находим самый дешевый по наличию и сохраняем координаты.
                            if (market.getSalesmanList().get(j).getProductList().get(l).getPrice() < k) {
                                k = market.getSalesmanList().get(j).getProductList().get(l).getPrice();
                                x = j;
                                y = l;
                            }
                        }
                    }
                }
                if (k == 99999) {
                    customer.getPurchaseList().get(i).setSalesmanN("\tНет в наличии ни у одного продавца.");

                    customer.setExpectedPurchaseList(new Product(exp, customer.getPurchaseList().get(i).getName(),
                            customer.getPurchaseList().get(i).getCount(), 0, 0, customer.getPurchaseList().get(i).getSalesmanN()));
                    break;
                } else {
                    customer.getPurchaseList().get(i).setSalesmanN(market.getSalesmanList().get(x).getNameSalesman());
                    int m = Math.min(customer.getPurchaseList().get(i).getCount(), market.getSalesmanList().get(x).getProductList().get(y).getRemainder());

                    int z = customer.getPurchaseList().get(i).getCount();
                    market.getSalesmanList().get(x).getProductList().get(y).setSold(m);

                    customer.getPurchaseList().get(i).setCount(customer.getPurchaseList().get(i).getCount()-m);

                    customer.setExpectedPurchaseList(new Product(exp, customer.getPurchaseList().get(i).getName(),
                            z, market.getSalesmanList().get(x).getProductList().get(y).getPrice(), m,
                            customer.getPurchaseList().get(i).getSalesmanN()));
                }
            } while (customer.getPurchaseList().get(i).getCount() != 0);
        }

        int b = 0;
        for (int j = 0; j < 6; j++) {
            b += customer.getExpectedPurchaseList().get(j).getProceeds();
        }
        System.out.println("        СПИСОК РЕАЛИЗАЦИИ ТОВАРОВ ПРОДАВЦАМИ");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println(market);
        System.out.println("        СПИСОК ПОКУПОК СЛУЧАЙНОГО ПОКУПАТЕЛЯ " + customer.getNameCustomer());
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println(customer);

        System.out.println(customer.getNameCustomer() + " потратил - " + b);

    }

    private static void selection(int j,Product[] arrProduct,Product product,
                                  String person, int r, Salesman[] arrSalesmen, int i, Customer customer) {
        int n = 0;
        do {
            for (int s = j - 1; s >= 0; s--) {
                if (arrProduct[s].getName().equals(product.clone(person, r).getName())) {
                    n = 0;
                    r = (int) (Math.random() * 9);
                    break;
                } else {
                    n++;
                }
            }
            if (n == j) {
                arrProduct[j] = product.clone(person, r);
                if (person.equals("sal")) {
                    arrSalesmen[i].setProductList(arrProduct[j]);
                } else {
                    customer.setPurchaseList(arrProduct[j]);
                }
            }
        } while (n != j);
    }


    public static int numberOfAthletes() {
        int x;
        while (true) {
            try {
                x = in.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели стоку");
                in.next();
            }
        }
        return x;
    }
}
