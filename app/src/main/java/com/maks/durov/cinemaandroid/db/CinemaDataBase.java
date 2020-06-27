package com.maks.durov.cinemaandroid.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.maks.durov.cinemaandroid.dao.MovieDao;
import com.maks.durov.cinemaandroid.model.Movie;

@Database(entities = {Movie.class}, version = 1)
public abstract class CinemaDataBase extends RoomDatabase {
    private static CinemaDataBase instance;

    public abstract MovieDao movieDao();

    public static synchronized CinemaDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    CinemaDataBase.class, "cinema_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
