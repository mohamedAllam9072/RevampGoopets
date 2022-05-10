package com.example.mygopets.ui.ads.models.ads;

import com.example.mygopets.ui.ads.models.AdDetails.Client;
import com.example.mygopets.ui.ads.models.AdDetails.Images;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class AdData implements Serializable {
    @Expose
    @SerializedName("updated_at")
    private int updated_at;
    @Expose
    @SerializedName("created_at")
    private int created_at;
    @Expose
    @SerializedName("region_id")
    private int region_id;
    @Expose
    @SerializedName("city_id")
    private int city_id;
    @Expose
    @SerializedName("category_id")
    private int category_id;
    @Expose
    @SerializedName("region")
    private String region;
    @Expose
    @SerializedName("city")
    private String city;
    @Expose
    @SerializedName("premium")
    private int premium;
    @Expose
    @SerializedName("image")
    private String image;
    @Expose
    @SerializedName("price")
    private String price;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("id")
    private int id;
    @Expose
    @SerializedName("phone")
    private String phone;
    @Expose
    @SerializedName("category")
    private String category;
    @Expose
    @SerializedName("client")
    private Client client;
    @Expose
    @SerializedName("images")
    private List<Images> images;
    @Expose
    @SerializedName("bio")
    private String bio;

    public int getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(int updated_at) {
        this.updated_at = updated_at;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
