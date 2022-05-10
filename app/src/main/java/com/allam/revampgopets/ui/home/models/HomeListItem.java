package com.allam.revampgopets.ui.home.models;

public class HomeListItem {
    private final int image;
    private final String title;
    private final int screenFlag;

    public HomeListItem(int image, String title, int screenFlag) {
        this.image = image;
        this.title = title;
        this.screenFlag = screenFlag;
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
