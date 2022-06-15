package com.allam.revampgopets.db.offlineRoom;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.allam.revampgopets.db.models.content.category.Category;
import com.allam.revampgopets.db.models.content.city.CityData;
import com.allam.revampgopets.db.offlineRoom.DAO.CategoryDAO;
import com.allam.revampgopets.db.offlineRoom.DAO.ChatOwnerDAO;
import com.allam.revampgopets.db.offlineRoom.DAO.CityDAO;
import com.allam.revampgopets.ui.allChats.models.ChatModel;
import com.allam.revampgopets.utils.App;


@Database(
        entities = {
                CityData.class, Category.class, ChatModel.class
        }, version = 1)
public abstract class OfflineDatabase extends RoomDatabase {
    private static OfflineDatabase instance;

    public static synchronized OfflineDatabase getInstance() {
        if (instance == null) {
            instance = Room.databaseBuilder(App.getContext()
                            , OfflineDatabase.class, "myGoopetsDB")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract CityDAO cityDAO();

    public abstract CategoryDAO categoryDAO();

    public abstract ChatOwnerDAO chatOwnerDAO();


}
