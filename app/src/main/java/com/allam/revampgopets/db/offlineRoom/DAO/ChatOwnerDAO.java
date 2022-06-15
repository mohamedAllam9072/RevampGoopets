package com.allam.revampgopets.db.offlineRoom.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.allam.revampgopets.ui.allChats.models.ChatModel;

import java.util.List;

@Dao
public interface ChatOwnerDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<ChatModel> chatOwnersList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertChatOwner(ChatModel chatOwner);

    @Delete
    void delete(ChatModel chatOwner);

    @Update
    void update(ChatModel chatOwner);

    @Query("SELECT * FROM chatOwnerTable WHERE id LIKE :id")
    LiveData<ChatModel> select(int id);


    @Query("SELECT * FROM chatOwnerTable")
    LiveData<List<ChatModel>> getChatOwnersList();
}
