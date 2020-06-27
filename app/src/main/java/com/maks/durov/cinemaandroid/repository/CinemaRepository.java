package com.maks.durov.cinemaandroid.repository;

import android.content.Context;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import javax.inject.Inject;
import lombok.AllArgsConstructor;
import com.maks.durov.cinemaandroid.dao.MovieDao;
import com.maks.durov.cinemaandroid.model.Movie;
import java.util.List;

public class CinemaRepository {
    private final MovieDao movieDao;

    @Inject
    public CinemaRepository(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public void insert(Movie movie) {
        new InsertAsyncTask(movieDao).execute(movie);
    }

    public void update(Movie movie) {
        movieDao.update(movie);
    }

    public LiveData<List<Movie>> getMovies() {
        return movieDao.getAllMovies();
    }

    @AllArgsConstructor
    private static class InsertAsyncTask extends AsyncTask<Movie, Void, Long>{
        private final MovieDao movieDao;

        @Override
        protected Long doInBackground(Movie... movies) {
            return movieDao.insert(movies[0]);
        }
    }
}
