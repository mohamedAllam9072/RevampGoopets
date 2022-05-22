package com.allam.revampgopets.ui.ads.models.adOwner;

import com.allam.revampgopets.ui.ads.models.AdDetails.Client;
import com.allam.revampgopets.ui.ads.models.ads.AdData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @Expose
    @SerializedName("advertisements")
    private List<AdData> advertisements;
    @Expose
    @SerializedName("count")
    private int count;
    @Expose
    @SerializedName("client")
    private Client client;

    public List<AdData> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<AdData> advertisements) {
        this.advertisements = advertisements;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
