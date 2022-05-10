package com.allam.revampgopets.ui.ads.models.ads;

import com.allam.revampgopets.db.models.content.city.Meta;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AdResponse {
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
    @SerializedName("data")
    private List<AdData> data;

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

    public List<AdData> getData() {
        return data;
    }

    public void setData(List<AdData> data) {
        this.data = data;
    }
}
