package com.example.mygopets.db.offlineRoom.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mygopets.db.models.content.category.Category;

import java.util.List;

@Dao
public interface CategoryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Category> list);

    @Delete
    void delete(Category category);

    @Update
    void update(Category category);


    @Query("SELECT * FROM category_table")
    LiveData<List<Category>> getALlCategories();
}
