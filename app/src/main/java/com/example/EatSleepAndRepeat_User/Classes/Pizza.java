package com.example.EatSleepAndRepeat_User.Classes;

import java.io.Serializable;

public class Pizza implements Serializable {
    public String pizzaname;
    public String description;
    public String tipo;
    public int price;

    public Pizza(){
    }

    public Pizza(String pizzaname, String description, String tipo, int price) {
        this.pizzaname = pizzaname;
        this.description = description;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
