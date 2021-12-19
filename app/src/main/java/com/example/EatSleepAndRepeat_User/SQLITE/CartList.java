package com.example.EatSleepAndRepeat_User.SQLITE;

public class CartList {

    String name;
    String description;
    String quantity;
    String price;
    String image;
    String category;
    int id;
    String idFirebase;

    public CartList(String name, String description, String quantity, String price, String image, int id, String idFirebase, String category) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.id = id;
        this.idFirebase = idFirebase;
        this.category = category;

    }
    public CartList(String name, String description, String quantity, String price, String image, String idFirebase, String category) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.idFirebase = idFirebase;
        this.category = category;
    }
    public CartList(){

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIdFirebase() {
        return idFirebase;
    }

    public void setIdFirebase(String idFirebase) {
        this.idFirebase = idFirebase;
    }
}