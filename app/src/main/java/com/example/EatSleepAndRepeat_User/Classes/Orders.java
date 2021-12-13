package com.example.EatSleepAndRepeat_User.Classes;

import java.io.Serializable;

public class Orders implements Serializable {
    public String id;
    public String name;
    public double price;
    public String status;

    public Orders(){
    }

    public Orders(String id, String name, double price, String status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String Id) { this.id = Id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
