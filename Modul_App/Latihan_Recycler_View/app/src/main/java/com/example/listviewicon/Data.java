package com.example.listviewicon;

public class Data {
    private int imageView;
    private String title;
    private String desc;

    public Data(int imageView, String title, String desc) {
        this.imageView = imageView;
        this.title = title;
        this.desc = desc;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
