package com.example.EatSleepAndRepeat_User.SQLITE;

public class CartList {

    String nom;
    String descripcion;
    String cantidad;
    String precio;

    public CartList(String nom, String descripcion, String cantidad, String precio) {
        this.nom = nom;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getCantidad() { return cantidad; }
    public void setCantidad(String cantidad) { this.cantidad = cantidad; }

    public String getPrecio() { return precio; }
    public void setPrecio(String precio) { this.precio = precio; }

}
