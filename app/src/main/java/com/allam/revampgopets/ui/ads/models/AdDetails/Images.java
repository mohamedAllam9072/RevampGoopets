package com.allam.revampgopets.ui.ads.models.AdDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images {

    private String path;

    public Images() {
    }

    @Expose
    @SerializedName("image")
    private String image;
    @Expose
    @SerializedName("id")
    private int id;

    public Images(int id, String image) {
        this.image = image;
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
