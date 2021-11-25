package com.example.myapplication.Classes;

import java.io.Serializable;

public class Dish implements Serializable {
    public String dishname;
    public String description;
    public String tipo;
    public int price;

    public Dish(){
    }

    public Dish(String dishname, String description, String tipo, int price) {
        this.dishname = dishname;
        this.description = description;
        this.tipo = tipo;
        this.price = price;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
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
