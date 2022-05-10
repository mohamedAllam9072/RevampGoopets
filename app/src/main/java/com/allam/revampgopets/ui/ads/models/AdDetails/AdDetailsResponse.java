package com.example.mygopets.ui.ads.models.AdDetails;

import com.example.mygopets.ui.ads.models.ads.AdData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdDetailsResponse {
    @Expose
    @SerializedName("data")
    private AdData data;
    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("status")
    private boolean status;

    public AdData getData() {
        return data;
    }

    public void setData(AdData data) {
        this.data = data;
    }

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
}
