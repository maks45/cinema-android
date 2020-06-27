package com.maks.durov.cinemaandroid.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.maks.durov.cinemaandroid.model.Movie;
import java.util.List;

@Dao
public interface MovieDao {

    @Insert
    void insert(Movie movie);

    @Update
    void update(Movie movie);

    @Query("SELECT * FROM movies")
    LiveData<List<Movie>> getAllMovies();
}

