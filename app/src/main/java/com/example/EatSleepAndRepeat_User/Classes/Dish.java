package com.example.EatSleepAndRepeat_User.Classes;

import java.io.Serializable;

public class Dish implements Serializable {
    public String dishId;
    public String name;
    public String description;
    public String category;
    public double price;
    public int id;

    public Dish(){
    }

    public Dish(String dishId, String name, String description, String type, double price) {
        this.dishId = dishId;
        this.name = name;
        this.description = description;
        this.category = type;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }
}
