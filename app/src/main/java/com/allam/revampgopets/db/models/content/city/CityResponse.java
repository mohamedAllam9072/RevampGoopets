package com.example.mygopets.db.models.content.city;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityResponse {
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
    private List<CityData> data;

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

    public List<CityData> getCityData() {
        return data;
    }

    public void setCityData(List<CityData> data) {
        this.data = data;
    }
}
