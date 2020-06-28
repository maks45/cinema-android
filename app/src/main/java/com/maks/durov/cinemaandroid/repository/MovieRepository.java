package com.maks.durov.cinemaandroid.repository;

import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import javax.inject.Inject;
import lombok.AllArgsConstructor;
import com.maks.durov.cinemaandroid.dao.MovieDao;
import com.maks.durov.cinemaandroid.model.Movie;
import java.util.List;

public class MovieRepository {
    private final MovieDao movieDao;

    @Inject
    public MovieRepository(MovieDao movieDao) {
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
    private static class UpdateAsyncTask extends AsyncTask<Movie, Void, Void> {
        private final MovieDao movieDao;

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDao.update(movies[0]);
            return null;
        }
    }

    @AllArgsConstructor
    private static class InsertAsyncTask extends AsyncTask<Movie, Void, Void> {
        private final MovieDao movieDao;

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDao.insert(movies[0]);
            return null;
        }
    }
}
