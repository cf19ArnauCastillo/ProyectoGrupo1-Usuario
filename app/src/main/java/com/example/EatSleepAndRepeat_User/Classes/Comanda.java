package com.example.EatSleepAndRepeat_User.Classes;

import java.io.Serializable;

public class Comanda implements Serializable {
    public String Id;
    public String name;
    public double price;
    public String Estado;

    public Comanda(){
    }

    public Comanda(String Id, String name, double price, String Estado) {
        this.Id = Id;
        this.name = name;
        this.price = price;
        this.Estado = Estado;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) { this.Id = Id; }

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

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
}
