package com.allam.revampgopets.db.models.content.city;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "cities_table")
public class CityData {
    @PrimaryKey
    @Expose
    @SerializedName("id")
    private int id;
    @Expose
    @SerializedName("name")
    private String name;

    public CityData(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }
}
