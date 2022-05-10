package com.allam.revampgopets.db.models.content.city;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {
    @Expose
    @SerializedName("last")
    private String last;
    @Expose
    @SerializedName("first")
    private String first;

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }
}
