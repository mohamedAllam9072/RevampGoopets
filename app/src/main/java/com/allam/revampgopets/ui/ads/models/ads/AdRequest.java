package com.allam.revampgopets.ui.ads.models.ads;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AdRequest {
    @Expose
    @SerializedName("city_id")
    private int city_id;
    @Expose
    @SerializedName("region_id")
    private int region_id;
    @Expose
    @SerializedName("category_id")
    private int category_id;
    @Expose
    @SerializedName("sort")
    private int sort;
    @Expose
    @SerializedName("search")
    private String search;
    @Expose
    @SerializedName("page")
    private int page;

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
