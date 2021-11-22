package com.example.myapplication.Classes;

import java.io.Serializable;

public class Pizza implements Serializable {
    public String pizzaname;
    public String description;
    public int price;

    public Pizza(){
    }

    public Pizza(String playerName, int age, String position, int shirtNo, int goal) {
        this.pizzaname = pizzaname;
        this.description = description;
        this.price = price;

    }

    public String getPizzaname() {
        return pizzaname;
    }

    public void setPizzaname(String pizzaname) {
        this.pizzaname = pizzaname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
