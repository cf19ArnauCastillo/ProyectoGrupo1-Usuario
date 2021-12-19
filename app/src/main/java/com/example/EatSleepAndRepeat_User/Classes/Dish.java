package com.example.EatSleepAndRepeat_User.Classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Dish implements Serializable, Parcelable {
    String id;
    String imageName;
    String category;
    String name;
    String description;
    double price;

    public Dish(String name, String description, String category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public Dish(String id, String imageName, String category, String name, String description, double price) {
        this.id = id;
        this.imageName = imageName;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;

    }
    protected Dish(Parcel in) {
        id = in.readString();
        description = in.readString();
        category = in.readString();
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
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

    public String getId() {
        return id;
    }

    public void setId(String dishId) {
        this.id = dishId;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(description);
        dest.writeString(category);
    }
    public static final Creator<Dish> CREATOR = new Creator<Dish>() {
        @Override
        public Dish createFromParcel(Parcel in) {
            return new Dish(in);
        }

        @Override
        public Dish[] newArray(int size) {
            return new Dish[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }
}
