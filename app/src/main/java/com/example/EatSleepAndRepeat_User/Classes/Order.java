package com.example.EatSleepAndRepeat_User.Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    public String user;
    public ArrayList<ItemCart> products;
    private String status;
    private String date;
    private Double totalPrice;



    public Order() {
    }


    public Order(String user, ArrayList<ItemCart> products, String status, String date, Double totalPrice) {

        this.user = user;
        this.products = products;
        this.status = status;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public ArrayList<ItemCart> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ItemCart> products) {
        this.products = products;
    }
}

