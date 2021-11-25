package com.example.EatSleepAndRepeat_User.Classes;

import java.io.Serializable;

public class Dish implements Serializable {
    public String name;
    public String description;
    public String type;
    public int price;

    public Dish(){
    }

    public Dish(String name, String description, String type, int price) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.price = price;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
