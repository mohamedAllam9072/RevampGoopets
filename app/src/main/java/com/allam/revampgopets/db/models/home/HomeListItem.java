package com.example.mygopets.db.models.home;

public class HomeListItem {
    private  int image;
    private  String title;
    private int screenFlag;

    public HomeListItem(int image, String title,int screenFlag) {
        this.image = image;
        this.title = title;
        this.screenFlag =screenFlag;
    }

    public int getScreenFlag() {
        return screenFlag;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
