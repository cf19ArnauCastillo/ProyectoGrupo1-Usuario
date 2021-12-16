package com.example.EatSleepAndRepeat_User.Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Orders implements Serializable {
    public String user;
    public ArrayList<ItemCart> products;


    public Orders() {
    }

    public Orders(String user, ArrayList<ItemCart> products) {
        this.user = user;
        this.products = products;
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


