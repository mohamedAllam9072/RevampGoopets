package com.example.mygopets.db.offlineRoom.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mygopets.db.models.content.city.CityData;

import java.util.List;

@Dao
public interface CityDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<CityData> cityList);

    @Delete
    void delete(CityData city);

    @Update
    void update(CityData city);


    @Query("SELECT * FROM cities_table")
    LiveData<List<CityData>> getAllCities();
}
