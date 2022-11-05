package com.example.recyclerviewapp;

public class DataList {
    private String title;
    private String price;
    private int imageId;

    public DataList(String title, String price, int imageId) {
        this.title = title;
        this.price = price;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
