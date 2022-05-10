package com.example.mygopets.db.models.content.city;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {
    @Expose
    @SerializedName("total")
    private int total;
    @Expose
    @SerializedName("to")
    private int to;
    @Expose
    @SerializedName("per_page")
    private int per_page;
    @Expose
    @SerializedName("path")
    private String path;
    @Expose
    @SerializedName("last_page")
    private int last_page;
    @Expose
    @SerializedName("from")
    private int from;
    @Expose
    @SerializedName("current_page")
    private int current_page;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getLast_page() {
        return last_page;
    }

    public void setLast_page(int last_page) {
        this.last_page = last_page;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }
}
