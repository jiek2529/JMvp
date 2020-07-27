package com.jiek.jmvp.beans;

public class Goods {
    public String imageUrl;
    public String name;

    public Goods(String name, String imageUrl) {
        this.imageUrl = imageUrl;
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
