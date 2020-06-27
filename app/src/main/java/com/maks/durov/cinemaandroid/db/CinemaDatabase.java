package com.maks.durov.cinemaandroid.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.maks.durov.cinemaandroid.dao.MovieDao;
import com.maks.durov.cinemaandroid.model.Movie;

@Database(entities = {Movie.class}, version = 1)
public abstract class CinemaDatabase extends RoomDatabase {
    public abstract MovieDao movieDao();
}
