package com.example.EatSleepAndRepeat_User.Classes;

import java.io.Serializable;

public class Category implements Serializable {
    String categoryName;
    String id;
    String imagePath;

    public Category(){
    }

    public Category(String categoryName, String id, String imagePath) {
        this.categoryName = categoryName;
        this.id = id;
        this.imagePath = imagePath;
    }

    public Category(Category category) {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
