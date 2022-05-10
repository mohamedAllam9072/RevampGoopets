package com.example.mygopets.db.offlineRoom;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mygopets.db.models.content.category.Category;
import com.example.mygopets.db.models.content.city.CityData;
import com.example.mygopets.db.offlineRoom.DAO.CategoryDAO;
import com.example.mygopets.db.offlineRoom.DAO.CityDAO;
import com.example.mygopets.utils.App;


@Database(entities = {CityData.class, Category.class}, version = 1)
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
//
//    private static final Callback roomCallback = new Callback() {
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//            new PopulateDBAsyncTask(instance).execute();
//        }
//    };
//
//    private static class PopulateDBAsyncTask extends AsyncTask<Void, Void, Void> {
//        private final AddressDao addressDao;
//
//        public PopulateDBAsyncTask(OfflineDatabase db) {
//            addressDao = db.addressDao();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            addressDao.insert(new Address(0, "25.2048", "55.2708", "dobai", "street1", 1, 2, 3, "mark", 1));
//
//            return null;
//        }
//    }


}
