package com.allam.revampgopets.db.models.content.category;

import com.allam.revampgopets.db.models.content.city.Links;
import com.allam.revampgopets.db.models.content.city.Meta;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryResponse {
    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("status")
    private boolean status;
    @Expose
    @SerializedName("meta")
    private Meta meta;
    @Expose
    @SerializedName("links")
    private Links links;
    @Expose
    @SerializedName("data")
    private List<Category> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<Category> getData() {
        return data;
    }

    public void setCityData(List<Category> data) {
        this.data = data;
    }
}
