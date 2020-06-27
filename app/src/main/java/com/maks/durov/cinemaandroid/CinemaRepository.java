package com.maks.durov.cinemaandroid;

import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import javax.inject.Inject;
import lombok.AllArgsConstructor;
import com.maks.durov.cinemaandroid.dao.MovieDao;
import com.maks.durov.cinemaandroid.db.CinemaDataBase;
import com.maks.durov.cinemaandroid.model.Movie;
import java.util.List;

public class CinemaRepository {
    private MovieDao movieDao;
    private LiveData<List<Movie>> movies;

    @Inject
    public CinemaRepository(CinemaApplication cinemaApplication) {
        CinemaDataBase cinemaDataBase = CinemaDataBase.getInstance(cinemaApplication);
        movieDao = cinemaDataBase.movieDao();
        movies = movieDao.getAllMovies();
    }

    public void insert(Movie movie) {
        new InsertAsyncTask(movieDao).execute(movie);
    }

    public void delete(Movie movie) {

    }

    public void update(Movie movie) {

    }

    public LiveData<List<Movie>> getMovies() {
        return movies;
    }

    @AllArgsConstructor
    private static class InsertAsyncTask extends AsyncTask<Movie, Void, Void>{
        private final MovieDao movieDao;

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDao.insert(movies[0]);
            return null;
        }
    }
}
